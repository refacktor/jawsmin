package com.aws.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;

/**
 * 
 * @see <a href=
 *      "http://docs.aws.amazon.com/goto/WebAPI/logs-2014-03-28/DescribeLogStreams"
 *      target="_top">AWS API Documentation</a>
 */
public class DescribeLogStreamsResult extends JsonMapperModel implements Serializable, Cloneable {

	/**
	 * <p>
	 * The log streams.
	 * </p>
	 */
	private ArrayList<LogStream> logStreams;

	private String nextToken;

	/**
	 * <p>
	 * The log streams.
	 * </p>
	 * 
	 * @return The log streams.
	 */

	public java.util.List<LogStream> getLogStreams() {
		if (logStreams == null) {
			logStreams = new ArrayList<LogStream>();
		}
		return logStreams;
	}

	/**
	 * <p>
	 * The log streams.
	 * </p>
	 * 
	 * @param logStreams The log streams.
	 */

	public void setLogStreams(java.util.Collection<LogStream> logStreams) {
		if (logStreams == null) {
			this.logStreams = null;
			return;
		}

		this.logStreams = new ArrayList<LogStream>(logStreams);
	}

	/**
	 * <p>
	 * The log streams.
	 * </p>
	 * <p>
	 * <b>NOTE:</b> This method appends the values to the existing list (if any).
	 * Use {@link #setLogStreams(java.util.Collection)} or
	 * {@link #withLogStreams(java.util.Collection)} if you want to override the
	 * existing values.
	 * </p>
	 * 
	 * @param logStreams The log streams.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public DescribeLogStreamsResult withLogStreams(LogStream... logStreams) {
		if (this.logStreams == null) {
			setLogStreams(new ArrayList<LogStream>(logStreams.length));
		}
		for (LogStream ele : logStreams) {
			this.logStreams.add(ele);
		}
		return this;
	}

	/**
	 * <p>
	 * The log streams.
	 * </p>
	 * 
	 * @param logStreams The log streams.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public DescribeLogStreamsResult withLogStreams(java.util.Collection<LogStream> logStreams) {
		setLogStreams(logStreams);
		return this;
	}

	/**
	 * @param nextToken
	 */

	public void setNextToken(String nextToken) {
		this.nextToken = nextToken;
	}

	/**
	 * @return
	 */

	public String getNextToken() {
		return this.nextToken;
	}

	/**
	 * @param nextToken
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public DescribeLogStreamsResult withNextToken(String nextToken) {
		setNextToken(nextToken);
		return this;
	}

	/**
	 * Returns a string representation of this object. This is useful for testing
	 * and debugging. Sensitive data will be redacted from this string using a
	 * placeholder value.
	 *
	 * @return A string representation of this object.
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		JsonObject modelJson = Json.object();
		if (getLogStreams() != null) {
			JsonArray tgs = Json.array();

			logStreams.stream().forEach(logStream -> {

				tgs.add(logStream.toString());

			});

			modelJson.set("logStreams", tgs);
		}
		if (getNextToken() != null)
			modelJson.set("nextToken", nextToken);

		return modelJson.toString();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof DescribeLogStreamsResult == false)
			return false;
		DescribeLogStreamsResult other = (DescribeLogStreamsResult) obj;
		if (other.getLogStreams() == null ^ this.getLogStreams() == null)
			return false;
		if (other.getLogStreams() != null && other.getLogStreams().equals(this.getLogStreams()) == false)
			return false;
		if (other.getNextToken() == null ^ this.getNextToken() == null)
			return false;
		if (other.getNextToken() != null && other.getNextToken().equals(this.getNextToken()) == false)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashCode = 1;

		hashCode = prime * hashCode + ((getLogStreams() == null) ? 0 : getLogStreams().hashCode());
		hashCode = prime * hashCode + ((getNextToken() == null) ? 0 : getNextToken().hashCode());
		return hashCode;
	}

	@Override
	public DescribeLogStreamsResult clone() {
		try {
			return (DescribeLogStreamsResult) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(
					"Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
		}
	}

	@Override
	public JsonMapperModel toModel(String json) {
		JsonObject reponseJson = Json.parse(json).asObject();
		DescribeLogStreamsResult result = new DescribeLogStreamsResult();
		if (reponseJson.getString("nextToken", null) != null)
			result.setNextToken(reponseJson.get("nextToken").asString());
		JsonArray logsArrayJson = reponseJson.get("logStreams").asArray();
		List<LogStream> logs = new ArrayList<>();
		logsArrayJson.forEach(jsonObj -> {
			LogStream log = new LogStream();
			if (jsonObj.asObject().get("logStreamName") != null)
				log.setLogStreamName(jsonObj.asObject().get("logStreamName").asString());
			if (jsonObj.asObject().get("creationTime") != null)
				log.setCreationTime(jsonObj.asObject().get("creationTime").asLong());

			if (jsonObj.asObject().get("firstEventTimestamp") != null)
				log.setFirstEventTimestamp(jsonObj.asObject().get("firstEventTimestamp").asLong());

			if (jsonObj.asObject().get("lastEventTimestamp") != null)
				log.setLastEventTimestamp(jsonObj.asObject().get("lastEventTimestamp").asLong());

			if (jsonObj.asObject().get("lastIngestionTime") != null)
				log.setLastIngestionTime(jsonObj.asObject().get("lastIngestionTime").asLong());

			if (jsonObj.asObject().get("uploadSequenceToken") != null)
				log.setUploadSequenceToken(jsonObj.asObject().get("uploadSequenceToken").asString());

			if (jsonObj.asObject().get("arn") != null)
				log.setArn(jsonObj.asObject().get("arn").asString());

			if (jsonObj.asObject().get("storedBytes") != null)
				log.setStoredBytes(jsonObj.asObject().get("storedBytes").asLong());

			logs.add(log);

		});
		result.setLogStreams(logs);
		return result;
	}

}
