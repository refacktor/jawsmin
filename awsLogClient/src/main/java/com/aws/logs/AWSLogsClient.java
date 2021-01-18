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
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=PutLogEvents",
				Constants.SERVICE + "." + Constants.REGION + "."+Constants.DOMAIN, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST", Constants.URL+"/?Action=PutLogEvents");
		return HttpUtils.executeRequest(post, request, PutLogEventsResult.class);
	}

	public CreateLogGroupResult createLogGroup(CreateLogGroupRequest request) {
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=CreateLogGroup",
				Constants.SERVICE + "." + Constants.REGION +  "."+Constants.DOMAIN, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST", Constants.URL+"/?Action=CreateLogGroup");
		return HttpUtils.executeRequest(post, request, CreateLogGroupResult.class);
	}

	public DescribeLogGroupsResult describeLogGroups(DescribeLogGroupsRequest request) {
		// request = beforeClientExecution(request);
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=DescribeLogGroups",
				Constants.SERVICE + "." + Constants.REGION +  "."+Constants.DOMAIN, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST",Constants.URL+ "/?Action=DescribeLogGroups");
		return HttpUtils.executeRequest(post, request, DescribeLogGroupsResult.class);
	}

	public CreateLogStreamResult createLogStream(CreateLogStreamRequest request) {
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=CreateLogStream",
				Constants.SERVICE + "." + Constants.REGION +  "."+Constants.REGION, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST", Constants.URL+"/?Action=CreateLogStream");
		return HttpUtils.executeRequest(post, request, CreateLogStreamResult.class);
	}

	public DescribeLogStreamsResult describeLogStreams(DescribeLogStreamsRequest request) {
		HttpPost post = HttpUtils.createRequest(Constants.URL+"/?Action=DescribeLogStreams",
				Constants.SERVICE + "." + Constants.REGION +  "."+Constants.DOMAIN, Constants.KEY, Constants.SECRET, Constants.REGION, Constants.SERVICE,
				"POST", Constants.URL+"/?Action=DescribeLogStreams");
		return HttpUtils.executeRequest(post, request, DescribeLogStreamsResult.class);
	}

}
