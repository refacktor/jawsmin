package org.jawsmin.logs;

import java.io.IOException;
import java.net.HttpURLConnection;

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
import org.jawsmin.util.Constants;
import org.jawsmin.util.HttpUtils;

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
