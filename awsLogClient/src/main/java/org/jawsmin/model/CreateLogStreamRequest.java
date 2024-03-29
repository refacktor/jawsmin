package org.jawsmin.model;

import java.io.Serializable;

import org.jawsmin.json.Json;
import org.jawsmin.json.JsonObject;

/**
 * 
 * @see <a href=
 *      "http://docs.aws.amazon.com/goto/WebAPI/logs-2014-03-28/CreateLogStream"
 *      target="_top">AWS API Documentation</a>
 */
public class CreateLogStreamRequest implements Serializable, Cloneable {

	/**
	 * <p>
	 * The name of the log group.
	 * </p>
	 */
	private String logGroupName;
	/**
	 * <p>
	 * The name of the log stream.
	 * </p>
	 */
	private String logStreamName;

	/**
	 * Default constructor for CreateLogStreamRequest object. Callers should use
	 * the setter or fluent setter (with...) methods to initialize the object
	 * after creating it.
	 */
	public CreateLogStreamRequest() {
	}

	/**
	 * Constructs a new CreateLogStreamRequest object. Callers should use the
	 * setter or fluent setter (with...) methods to initialize any additional
	 * object members.
	 * 
	 * @param logGroupName
	 *            The name of the log group.
	 * @param logStreamName
	 *            The name of the log stream.
	 */
	public CreateLogStreamRequest(String logGroupName, String logStreamName) {
		setLogGroupName(logGroupName);
		setLogStreamName(logStreamName);
	}

	/**
	 * <p>
	 * The name of the log group.
	 * </p>
	 * 
	 * @param logGroupName
	 *            The name of the log group.
	 */

	public void setLogGroupName(String logGroupName) {
		this.logGroupName = logGroupName;
	}

	/**
	 * <p>
	 * The name of the log group.
	 * </p>
	 * 
	 * @return The name of the log group.
	 */

	public String getLogGroupName() {
		return this.logGroupName;
	}

	/**
	 * <p>
	 * The name of the log group.
	 * </p>
	 * 
	 * @param logGroupName
	 *            The name of the log group.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public CreateLogStreamRequest withLogGroupName(String logGroupName) {
		setLogGroupName(logGroupName);
		return this;
	}

	/**
	 * <p>
	 * The name of the log stream.
	 * </p>
	 * 
	 * @param logStreamName
	 *            The name of the log stream.
	 */

	public void setLogStreamName(String logStreamName) {
		this.logStreamName = logStreamName;
	}

	/**
	 * <p>
	 * The name of the log stream.
	 * </p>
	 * 
	 * @return The name of the log stream.
	 */

	public String getLogStreamName() {
		return this.logStreamName;
	}

	/**
	 * <p>
	 * The name of the log stream.
	 * </p>
	 * 
	 * @param logStreamName
	 *            The name of the log stream.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public CreateLogStreamRequest withLogStreamName(String logStreamName) {
		setLogStreamName(logStreamName);
		return this;
	}

	/**
	 * Returns a string representation of this object. This is useful for
	 * testing and debugging. Sensitive data will be redacted from this string
	 * using a placeholder value.
	 *
	 * @return A string representation of this object.
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		JsonObject modelJson = Json.object();
		if (logGroupName != null)
			modelJson.set("logGroupName", this.logGroupName);
		if (logStreamName != null)
			modelJson.set("logStreamName", this.logStreamName);

		return modelJson.toString();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof CreateLogStreamRequest == false)
			return false;
		CreateLogStreamRequest other = (CreateLogStreamRequest) obj;
		if (other.getLogGroupName() == null ^ this.getLogGroupName() == null)
			return false;
		if (other.getLogGroupName() != null && other.getLogGroupName()
				.equals(this.getLogGroupName()) == false)
			return false;
		if (other.getLogStreamName() == null ^ this.getLogStreamName() == null)
			return false;
		if (other.getLogStreamName() != null && other.getLogStreamName()
				.equals(this.getLogStreamName()) == false)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashCode = 1;

		hashCode = prime * hashCode + ((getLogGroupName() == null)
				? 0
				: getLogGroupName().hashCode());
		hashCode = prime * hashCode + ((getLogStreamName() == null)
				? 0
				: getLogStreamName().hashCode());
		return hashCode;
	}

	@Override
	public CreateLogStreamRequest clone() throws CloneNotSupportedException {
		return (CreateLogStreamRequest) super.clone();
	}

}
