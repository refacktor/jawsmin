package com.aws.logs;

import java.io.IOException;
import java.net.HttpURLConnection;

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
		HttpURLConnection post;
		try {
			post = HttpUtils.createRequest(
					Constants.URL + "/?Action=PutLogEvents&Version=2012-10-17",
					Constants.SERVICE + "." + Constants.REGION + "."
							+ Constants.DOMAIN,
					Constants.KEY, Constants.SECRET, Constants.REGION,
					Constants.SERVICE, "POST", "/", "PutLogEvents", request);
			return (PutLogEventsResult) HttpUtils.executeRequest(post, request,
					new PutLogEventsResult());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public CreateLogGroupResult createLogGroup(CreateLogGroupRequest request) {
		HttpURLConnection post;
		try {
			post = HttpUtils.createRequest(
					Constants.URL
							+ "/?Action=CreateLogGroup&Version=2012-10-17",
					Constants.SERVICE + "." + Constants.REGION + "."
							+ Constants.DOMAIN,
					Constants.KEY, Constants.SECRET, Constants.REGION,
					Constants.SERVICE, "POST", "/", "CreateLogGroup", request);
			return (CreateLogGroupResult) HttpUtils.executeRequest(post,
					request, new CreateLogGroupResult());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public DescribeLogGroupsResult describeLogGroups(
			DescribeLogGroupsRequest request) {
		// request = beforeClientExecution(request);
		HttpURLConnection post;
		try {
			post = HttpUtils.createRequest(
					Constants.URL
							+ "/?Action=DescribeLogGroups&Version=2012-10-17",
					Constants.SERVICE + "." + Constants.REGION + "."
							+ Constants.DOMAIN,
					Constants.KEY, Constants.SECRET, Constants.REGION,
					Constants.SERVICE, "POST", "/", "DescribeLogGroups",
					request);
			return (DescribeLogGroupsResult) HttpUtils.executeRequest(post,
					request, new DescribeLogGroupsResult());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public CreateLogStreamResult createLogStream(
			CreateLogStreamRequest request) {
		HttpURLConnection post;
		try {
			post = HttpUtils.createRequest(
					Constants.URL
							+ "/?Action=CreateLogStream&Version=2012-10-17",
					Constants.SERVICE + "." + Constants.REGION + "."
							+ Constants.DOMAIN,
					Constants.KEY, Constants.SECRET, Constants.REGION,
					Constants.SERVICE, "POST", "/", "CreateLogStream", request);
			return (CreateLogStreamResult) HttpUtils.executeRequest(post,
					request, new CreateLogStreamResult());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public DescribeLogStreamsResult describeLogStreams(
			DescribeLogStreamsRequest request) {
		HttpURLConnection post;
		try {
			post = HttpUtils.createRequest(
					Constants.URL
							+ "/?Action=DescribeLogStreams&Version=2012-10-17",
					Constants.SERVICE + "." + Constants.REGION + "."
							+ Constants.DOMAIN,
					Constants.KEY, Constants.SECRET, Constants.REGION,
					Constants.SERVICE, "POST", "/", "DescribeLogStreams",
					request);
			return (DescribeLogStreamsResult) HttpUtils.executeRequest(post,
					request, new DescribeLogStreamsResult());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
