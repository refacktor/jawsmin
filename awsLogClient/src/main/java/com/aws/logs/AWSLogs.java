package com.aws.logs;

import com.aws.model.CreateLogGroupRequest;
import com.aws.model.CreateLogGroupResult;
import com.aws.model.CreateLogStreamRequest;
import com.aws.model.CreateLogStreamResult;
import com.aws.model.DescribeLogGroupsRequest;
import com.aws.model.DescribeLogGroupsResult;
import com.aws.model.DescribeLogStreamsRequest;
import com.aws.model.DescribeLogStreamsResult;
import com.aws.model.PutLogEventsRequest;
import com.aws.model.PutLogEventsResult;

public interface AWSLogs {

	public PutLogEventsResult putLogEvents(PutLogEventsRequest request);

	public CreateLogGroupResult createLogGroup(CreateLogGroupRequest request);

	public DescribeLogGroupsResult describeLogGroups(DescribeLogGroupsRequest request);

	public CreateLogStreamResult createLogStream(CreateLogStreamRequest request);

	public DescribeLogStreamsResult describeLogStreams(DescribeLogStreamsRequest request);

}
