package org.jawsmin;

import java.util.Arrays;
import java.util.List;

import org.jawsmin.logs.AWSLogsClient;
import org.jawsmin.model.CreateLogGroupRequest;
import org.jawsmin.model.CreateLogStreamRequest;
import org.jawsmin.model.DescribeLogStreamsRequest;
import org.jawsmin.model.DescribeLogStreamsResult;
import org.jawsmin.model.InputLogEvent;
import org.jawsmin.model.PutLogEventsRequest;
import org.junit.Assert;
import org.junit.Test;

public class CloudwatchClientTest {

	@Test
	public void test() {
		final AWSLogsClient log = new AWSLogsClient();
		final String logGroupName = "TEST-"
				+ Long.toHexString(System.currentTimeMillis() / 1000);
		final String logStreamName = "Stream-1";

		CreateLogGroupRequest g = new CreateLogGroupRequest();
		g.setLogGroupName(logGroupName);
		log.createLogGroup(g);

		CreateLogStreamRequest logStream = new CreateLogStreamRequest();
		logStream.setLogGroupName(logGroupName);
		logStream.setLogStreamName(logStreamName);
		log.createLogStream(logStream);

		DescribeLogStreamsRequest describe = new DescribeLogStreamsRequest();
		describe.setLogGroupName(logGroupName);
		DescribeLogStreamsResult describeLogStreams = log
				.describeLogStreams(describe);
		Assert.assertTrue(describeLogStreams.getLogStreams().size() >= 1);

		List<InputLogEvent> logEvents = Arrays.asList(
				new InputLogEvent().withMessage("this is a test log event")
						.withTimestamp(System.currentTimeMillis()));
		log.putLogEvents(new PutLogEventsRequest(logGroupName, logStreamName,
				logEvents));
	}
}
