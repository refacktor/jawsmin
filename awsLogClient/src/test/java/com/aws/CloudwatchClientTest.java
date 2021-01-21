package com.aws;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.aws.logs.AWSLogsClient;
import com.aws.model.CreateLogGroupRequest;
import com.aws.model.CreateLogStreamRequest;
import com.aws.model.DescribeLogStreamsRequest;
import com.aws.model.DescribeLogStreamsResult;
import com.aws.model.InputLogEvent;
import com.aws.model.PutLogEventsRequest;

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
