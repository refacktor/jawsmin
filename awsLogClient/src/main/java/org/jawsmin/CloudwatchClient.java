package org.jawsmin;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.jawsmin.logs.AWSLogsClient;
import org.jawsmin.model.CreateLogGroupRequest;
import org.jawsmin.model.CreateLogStreamRequest;
import org.jawsmin.model.DescribeLogGroupsRequest;
import org.jawsmin.model.DescribeLogStreamsRequest;
import org.jawsmin.model.InputLogEvent;
import org.jawsmin.model.InvalidSequenceTokenException;
import org.jawsmin.model.LogGroup;
import org.jawsmin.model.LogStream;
import org.jawsmin.model.PutLogEventsRequest;
import org.jawsmin.model.PutLogEventsResult;

public class CloudwatchClient {

	final private static Logger logger = Logger.getLogger(CloudwatchClient.class.getName());

	protected static CloudwatchClient instance;

	public static synchronized CloudwatchClient getInstance() {
		if (instance == null) {
			instance = new CloudwatchClient();
		}
		return instance;
	}

	/**
	 * The queue used to buffer log entries
	 */
	private LinkedBlockingQueue<LogRecord> loggingEventsQueue = new LinkedBlockingQueue<>();
	/**
	 * the AWS Cloudwatch Logs API client
	 */
	protected AWSLogsClient awsLogsClient;

	private Formatter formatter = new SimpleFormatter();

	private AtomicReference<String> lastSequenceToken = new AtomicReference<>();

	/**
	 * The AWS Cloudwatch Log group name
	 */
	private String logGroupName;

	/**
	 * The AWS Cloudwatch Log stream name
	 */
	private String logStreamName;

	/**
	 * The maximum number of log entries to send in one go to the AWS Cloudwatch
	 * Log service
	 */
	private final static int messagesBatchSize = 128;

	private ScheduledThreadPoolExecutor exe;

	public CloudwatchClient() {
		super();
		try {
			init(System.getProperty("LOG_GROUP", "/default"), "default");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Alternate constructor required for unit-test.
	 * 
	 * @param formatter
	 * @param logGroup
	 * @param logStream
	 */
	protected CloudwatchClient(Formatter formatter, String logGroup,
			String logStream) {
		try {
			this.formatter = formatter;
			init(logGroup, logStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getLogGroupName() {
		return logGroupName;
	}

	private synchronized void sendMessages() {
		try {
			List<LogRecord> loggingEvents = new ArrayList<>();
			LogRecord polledLoggingEvent;
			for (;;) {
				polledLoggingEvent = loggingEventsQueue.poll();
				if (polledLoggingEvent != null) {
					loggingEvents.add(polledLoggingEvent);
				}

				if (polledLoggingEvent == null
						|| loggingEvents.size() >= messagesBatchSize) {
					sendMessages(loggingEvents);
					loggingEvents.clear();
				}

				if (polledLoggingEvent == null)
					break;
			}

		} catch (Exception e) {
			// should never happen
			logger.info("IGNORED: " + e.toString());
			e.printStackTrace();
		}
	}

	private void sendMessages(List<LogRecord> loggingEvents) {
		List<InputLogEvent> inputLogEvents = loggingEvents.stream()
				.sorted(Comparator.comparing(LogRecord::getMillis))
				.map(loggingEvent -> {
					String msg;
					// if (loggingEvent instanceof JsonLogRecord) {
					// msg = ((JsonLogRecord) loggingEvent).getMessage();
					// } else {
					msg = formatter.format(loggingEvent);
					// }
					return new InputLogEvent()
							.withTimestamp(loggingEvent.getMillis())
							.withMessage(msg);
				}).collect(toList());

		if (!loggingEvents.isEmpty()) {
			PutLogEventsRequest putLogEventsRequest = new PutLogEventsRequest(
					logGroupName, logStreamName, inputLogEvents);
			try {
				putLogEventsRequest.setSequenceToken(lastSequenceToken.get());
				PutLogEventsResult result = awsLogsClient
						.putLogEvents(putLogEventsRequest);
				lastSequenceToken.set(result.getNextSequenceToken());
			} catch (InvalidSequenceTokenException invalidSequenceTokenException) {
				logger.info("Resetting sequenceToken");
				putLogEventsRequest
						.setSequenceToken(invalidSequenceTokenException
								.getExpectedSequenceToken());
				PutLogEventsResult result = awsLogsClient
						.putLogEvents(putLogEventsRequest);
				lastSequenceToken.set(result.getNextSequenceToken());
			}
		}
	}

	protected synchronized void initializeBackgroundThreads() {
		exe = new ScheduledThreadPoolExecutor(1);
		exe.scheduleAtFixedRate(() -> {
			if (loggingEventsQueue.size() > 0) {
				sendMessages();
			}
		}, 0, 1, TimeUnit.SECONDS);
	}

	public synchronized void initializeCloudwatchResources(String logGroupName,
			String logStreamName) {

		this.logGroupName = logGroupName;
		this.logStreamName = logStreamName;

		DescribeLogGroupsRequest describeLogGroupsRequest = new DescribeLogGroupsRequest();
		describeLogGroupsRequest.setLogGroupNamePrefix(logGroupName);
		Optional<LogGroup> logGroupOptional = awsLogsClient
				.describeLogGroups(describeLogGroupsRequest).getLogGroups()
				.stream().filter(logGroup -> logGroup.getLogGroupName()
						.equals(logGroupName))
				.findFirst();
		if (!logGroupOptional.isPresent()) {
			CreateLogGroupRequest createLogGroupRequest = new CreateLogGroupRequest()
					.withLogGroupName(logGroupName);
			awsLogsClient.createLogGroup(createLogGroupRequest);
		}
		DescribeLogStreamsRequest describeLogStreamsRequest = new DescribeLogStreamsRequest()
				.withLogGroupName(logGroupName)
				.withLogStreamNamePrefix(logStreamName);
		Optional<LogStream> logStreamOptional = awsLogsClient
				.describeLogStreams(describeLogStreamsRequest).getLogStreams()
				.stream().filter(logStream -> logStream.getLogStreamName()
						.equals(logStreamName))
				.findFirst();
		if (!logStreamOptional.isPresent()) {
			logger.info("About to create LogStream: " + logStreamName
					+ " in LogGroup: " + logGroupName);
			CreateLogStreamRequest createLogStreamRequest = new CreateLogStreamRequest()
					.withLogGroupName(logGroupName)
					.withLogStreamName(logStreamName);
			awsLogsClient.createLogStream(createLogStreamRequest);
		}
	}

	public synchronized void publish(LogRecord record) {
		loggingEventsQueue.add(record);
	}

	private synchronized void init(String logGroupName, String logStreamName)
			throws IOException {
		logger.info("Initializing CloudwatchAppender with LogGroupName("
				+ logGroupName + ") and LogStreamName(" + logStreamName + ")");

		// this.awsLogsClient = AWSLogsClientBuilder.standard()
		// .withRegion(new DefaultAwsRegionProviderChain().getRegion())
		// .build();

		initializeCloudwatchResources(logGroupName, logStreamName);

		initializeBackgroundThreads();

	}

	public synchronized void close() throws SecurityException {
		exe.shutdown();
		try {
			exe.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			exe.shutdownNow();
		} finally {
			flush();
		}
	}

	public synchronized void flush() {
		sendMessages();
	}

	public static void main(String[] args) {
		CreateLogGroupRequest g = new CreateLogGroupRequest();
		g.setLogGroupName("GroupLog6");

		AWSLogsClient log = new AWSLogsClient();
		log.createLogGroup(g);
		CreateLogStreamRequest logStream = new CreateLogStreamRequest();
		logStream.setLogGroupName("GroupLog6");
		logStream.setLogStreamName("S1");
		log.createLogStream(logStream);
		DescribeLogStreamsRequest describe = new DescribeLogStreamsRequest();
		describe.setLogGroupName("GroupLog6");

		log.describeLogStreams(describe);
	}
}
