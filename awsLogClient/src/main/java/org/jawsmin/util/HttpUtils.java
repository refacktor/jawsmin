package org.jawsmin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jawsmin.logs.AWSV4Auth;
import org.jawsmin.model.JsonMapperModel;

public class HttpUtils {
	
	final private static Logger logger = Logger.getLogger(HttpUtils.class.getName());

	private static String getTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));// server timezone
		return dateFormat.format(new Date());
	}

	private static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));// server timezone
		return dateFormat.format(new Date());
	}
	public static HttpURLConnection createRequest(String url, String host,
			String key, String secret, String region, String service,
			String methode, String canonical, String action, Object payload)
			throws IOException {

		/**
		 * Add host without http or https protocol. You can also add other
		 * parameters based on your amazon service requirement.
		 */

		String xAmzDate = getTimeStamp();
		logger.info(xAmzDate);
		TreeMap<String, String> awsHeaders = new TreeMap<String, String>();
		awsHeaders.put("host", host);
		awsHeaders.put("x-amz-date", xAmzDate);
		awsHeaders.put("x-amz-target", "Logs_20140328." + action);
		awsHeaders.put("content-type", "application/x-amz-json-1.1");

		TreeMap<String, String> queryParam = null;
		queryParam = new TreeMap<String, String>();
		queryParam.put("Action", action);
		queryParam.put("Version", "2012-10-17");

		logger.info(payload.toString());

		AWSV4Auth aWSV4Auth = new AWSV4Auth.Builder(key, secret)
				.regionName(region).serviceName(service) // es - elastic
															// search.
															// use your
															// service
															// name
				.httpMethodName(methode) // GET, PUT, POST, DELETE, etc...
				.canonicalURI(canonical) // end point
				.date(xAmzDate)

				.queryParametes(queryParam) // query parameters if any
				.awsHeaders(awsHeaders) // aws header parameters
				.payload(payload.toString()) // payload if any
				.debug(false) // turn on the debug mode
				.build();
		aWSV4Auth.getHeaders();
		logger.info(
				"######################################################################");
		/* Get header calculated for request */
		Map<String, String> header = new TreeMap<String, String>(
				aWSV4Auth.getHeaders());

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");

		for (Map.Entry<String, String> entrySet : header.entrySet()) {
			String headerkey = entrySet.getKey();
			String value = entrySet.getValue();

			/* Attach header in your request */
			/* Simple get request */
			con.setRequestProperty(headerkey, value);

		}
		return con;
	}

	public static <T, S extends JsonMapperModel> JsonMapperModel executeRequest(
			HttpURLConnection request, T user, JsonMapperModel model) {

		try {

			String inputString = user.toString();
			logger.info(inputString);
			request.setDoOutput(true);

			try (OutputStream os = request.getOutputStream()) {
				byte[] input = inputString.getBytes("utf-8");
				os.write(input, 0, input.length);
				os.flush();
			}

			int responseCode = request.getResponseCode();
			logger.info("POST Response Code :: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(
						new InputStreamReader(request.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				logger.info(response.toString());
				return model.toModel(response.toString());

			} else {
				logger.info("POST request not worked");
				BufferedReader in = new BufferedReader(
						new InputStreamReader(request.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				throw new IllegalArgumentException(response.toString());
			}

		} catch (UnsupportedOperationException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unused")
	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {

		String newLine = System.getProperty("line.separator");
		String result;
		try (Stream<String> lines = new BufferedReader(
				new InputStreamReader(inputStream)).lines()) {
			result = lines.collect(Collectors.joining(newLine));
		}

		return result;

	}
}