package com.aws.logs;

import org.apache.http.client.methods.HttpPost;

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
import com.aws.util.Constants;
import com.aws.util.HttpUtils;

public class AWSLogsClient implements AWSLogs {

	public PutLogEventsResult putLogEvents(PutLogEventsRequest request) {
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=PutLogEvents&Version=2012-10-17",
				Constants.SERVICE + "." + Constants.REGION + "."+Constants.DOMAIN, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST","/", "PutLogEvents",request);
		return HttpUtils.executeRequest(post, request, PutLogEventsResult.class);
	}

	public CreateLogGroupResult createLogGroup(CreateLogGroupRequest request) {
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=CreateLogGroup&Version=2012-10-17",
				Constants.SERVICE + "." + Constants.REGION +  "."+Constants.DOMAIN, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST", "/","CreateLogGroup",request);
		return HttpUtils.executeRequest(post, request, CreateLogGroupResult.class);
	}

	public DescribeLogGroupsResult describeLogGroups(DescribeLogGroupsRequest request) {
		// request = beforeClientExecution(request);
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=DescribeLogGroups&Version=2012-10-17",
				Constants.SERVICE + "." + Constants.REGION +  "."+Constants.DOMAIN, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST","/", "DescribeLogGroups",request);
		return HttpUtils.executeRequest(post, request, DescribeLogGroupsResult.class);
	}

	public CreateLogStreamResult createLogStream(CreateLogStreamRequest request) {
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=CreateLogStream&Version=2012-10-17",
				Constants.SERVICE + "." + Constants.REGION +  "."+Constants.DOMAIN, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST", "/","CreateLogStream",request);
		return HttpUtils.executeRequest(post, request, CreateLogStreamResult.class);
	}

	public DescribeLogStreamsResult describeLogStreams(DescribeLogStreamsRequest request) {
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=DescribeLogStreams&Version=2012-10-17",
				Constants.SERVICE + "." + Constants.REGION +  "."+Constants.DOMAIN, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST","/", "DescribeLogStreams",request);
		return HttpUtils.executeRequest(post, request, DescribeLogStreamsResult.class);
	}

}
