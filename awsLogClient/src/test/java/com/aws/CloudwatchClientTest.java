package com.aws;

import org.junit.Test;

import com.aws.logs.AWSLogsClient;
import com.aws.model.CreateLogGroupRequest;
import com.aws.model.CreateLogStreamRequest;
import com.aws.model.DescribeLogStreamsRequest;


public class CloudwatchClientTest {

    @Test
    public void test() {
		AWSLogsClient log  = new AWSLogsClient();

    	
		CreateLogStreamRequest logStream = new CreateLogStreamRequest();
		logStream.setLogGroupName("test65");
		logStream.setLogStreamName("S1");
		log.createLogStream(logStream);
		DescribeLogStreamsRequest describe = new DescribeLogStreamsRequest();
		describe.setLogGroupName("GroupLo44");
		
		log.describeLogStreams(describe);
		
		CreateLogGroupRequest g = new CreateLogGroupRequest();
		g.setLogGroupName("test2");
		
		log.createLogGroup(g);
    }
}
