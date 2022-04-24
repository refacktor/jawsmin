package org.jawsmin.logs;

import org.jawsmin.model.CreateLogGroupRequest;
import org.jawsmin.model.CreateLogGroupResult;
import org.jawsmin.model.CreateLogStreamRequest;
import org.jawsmin.model.CreateLogStreamResult;
import org.jawsmin.model.DescribeLogGroupsRequest;
import org.jawsmin.model.DescribeLogGroupsResult;
import org.jawsmin.model.DescribeLogStreamsRequest;
import org.jawsmin.model.DescribeLogStreamsResult;
import org.jawsmin.model.PutLogEventsRequest;
import org.jawsmin.model.PutLogEventsResult;

public interface AWSLogs {

	public PutLogEventsResult putLogEvents(PutLogEventsRequest request);

	public CreateLogGroupResult createLogGroup(CreateLogGroupRequest request);

	public DescribeLogGroupsResult describeLogGroups(
			DescribeLogGroupsRequest request);

	public CreateLogStreamResult createLogStream(
			CreateLogStreamRequest request);

	public DescribeLogStreamsResult describeLogStreams(
			DescribeLogStreamsRequest request);

}
