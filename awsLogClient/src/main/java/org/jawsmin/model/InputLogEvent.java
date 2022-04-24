package org.jawsmin.model;

import java.io.Serializable;

import org.jawsmin.json.Json;
import org.jawsmin.json.JsonObject;

/**
 * <p>
 * Represents a log event, which is a record of activity that was recorded by
 * the application or resource being monitored.
 * </p>
 * 
 * @see <a href=
 *      "http://docs.aws.amazon.com/goto/WebAPI/logs-2014-03-28/InputLogEvent"
 *      target="_top">AWS API Documentation</a>
 */
public class InputLogEvent implements Serializable, Cloneable {

	public InputLogEvent() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * <p>
	 * The time the event occurred, expressed as the number of milliseconds
	 * after Jan 1, 1970 00:00:00 UTC.
	 * </p>
	 */
	private Long timestamp;
	/**
	 * <p>
	 * The raw event message.
	 * </p>
	 */
	private String message;

	/**
	 * <p>
	 * The time the event occurred, expressed as the number of milliseconds
	 * after Jan 1, 1970 00:00:00 UTC.
	 * </p>
	 * 
	 * @param timestamp
	 *            The time the event occurred, expressed as the number of
	 *            milliseconds after Jan 1, 1970 00:00:00 UTC.
	 */

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * <p>
	 * The time the event occurred, expressed as the number of milliseconds
	 * after Jan 1, 1970 00:00:00 UTC.
	 * </p>
	 * 
	 * @return The time the event occurred, expressed as the number of
	 *         milliseconds after Jan 1, 1970 00:00:00 UTC.
	 */

	public Long getTimestamp() {
		return this.timestamp;
	}

	/**
	 * <p>
	 * The time the event occurred, expressed as the number of milliseconds
	 * after Jan 1, 1970 00:00:00 UTC.
	 * </p>
	 * 
	 * @param timestamp
	 *            The time the event occurred, expressed as the number of
	 *            milliseconds after Jan 1, 1970 00:00:00 UTC.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public InputLogEvent withTimestamp(Long timestamp) {
		setTimestamp(timestamp);
		return this;
	}

	/**
	 * <p>
	 * The raw event message.
	 * </p>
	 * 
	 * @param message
	 *            The raw event message.
	 */

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * <p>
	 * The raw event message.
	 * </p>
	 * 
	 * @return The raw event message.
	 */

	public String getMessage() {
		return this.message;
	}

	/**
	 * <p>
	 * The raw event message.
	 * </p>
	 * 
	 * @param message
	 *            The raw event message.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public InputLogEvent withMessage(String message) {
		setMessage(message);
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
		if (getTimestamp() != null)
			modelJson.set("timestamp", this.timestamp);
		if (getMessage() != null)
			modelJson.set("message", this.message);
		return modelJson.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof InputLogEvent == false)
			return false;
		InputLogEvent other = (InputLogEvent) obj;
		if (other.getTimestamp() == null ^ this.getTimestamp() == null)
			return false;
		if (other.getTimestamp() != null
				&& other.getTimestamp().equals(this.getTimestamp()) == false)
			return false;
		if (other.getMessage() == null ^ this.getMessage() == null)
			return false;
		if (other.getMessage() != null
				&& other.getMessage().equals(this.getMessage()) == false)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashCode = 1;

		hashCode = prime * hashCode
				+ ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
		hashCode = prime * hashCode
				+ ((getMessage() == null) ? 0 : getMessage().hashCode());
		return hashCode;
	}

	@Override
	public InputLogEvent clone() {
		try {
			return (InputLogEvent) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(
					"Got a CloneNotSupportedException from Object.clone() "
							+ "even though we're Cloneable!",
					e);
		}
	}

	// @com.amazonaws.annotation.SdkInternalApi
	// @Override
	// public void marshall(ProtocolMarshaller protocolMarshaller) {
	// com.amazonaws.services.logs.model.transform.InputLogEventMarshaller.getInstance().marshall(this,
	// protocolMarshaller);
	// }
}
