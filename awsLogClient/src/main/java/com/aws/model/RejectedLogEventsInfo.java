package com.aws.model;

import java.io.Serializable;

/**
 * <p>
 * Represents the rejected events.
 * </p>
 * 
 * @see <a href=
 *      "http://docs.aws.amazon.com/goto/WebAPI/logs-2014-03-28/RejectedLogEventsInfo"
 *      target="_top">AWS API Documentation</a>
 */
public class RejectedLogEventsInfo implements Serializable, Cloneable {

	/**
	 * <p>
	 * The log events that are too new.
	 * </p>
	 */
	private Integer tooNewLogEventStartIndex;
	/**
	 * <p>
	 * The log events that are too old.
	 * </p>
	 */
	private Integer tooOldLogEventEndIndex;
	/**
	 * <p>
	 * The expired log events.
	 * </p>
	 */
	private Integer expiredLogEventEndIndex;

	public RejectedLogEventsInfo(Integer tooNewLogEventStartIndex,
			Integer tooOldLogEventEndIndex, Integer expiredLogEventEndIndex) {
		super();
		this.tooNewLogEventStartIndex = tooNewLogEventStartIndex;
		this.tooOldLogEventEndIndex = tooOldLogEventEndIndex;
		this.expiredLogEventEndIndex = expiredLogEventEndIndex;
	}

	public RejectedLogEventsInfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * <p>
	 * The log events that are too new.
	 * </p>
	 * 
	 * @param tooNewLogEventStartIndex
	 *            The log events that are too new.
	 */

	public void setTooNewLogEventStartIndex(Integer tooNewLogEventStartIndex) {
		this.tooNewLogEventStartIndex = tooNewLogEventStartIndex;
	}

	/**
	 * <p>
	 * The log events that are too new.
	 * </p>
	 * 
	 * @return The log events that are too new.
	 */

	public Integer getTooNewLogEventStartIndex() {
		return this.tooNewLogEventStartIndex;
	}

	/**
	 * <p>
	 * The log events that are too new.
	 * </p>
	 * 
	 * @param tooNewLogEventStartIndex
	 *            The log events that are too new.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public RejectedLogEventsInfo withTooNewLogEventStartIndex(
			Integer tooNewLogEventStartIndex) {
		setTooNewLogEventStartIndex(tooNewLogEventStartIndex);
		return this;
	}

	/**
	 * <p>
	 * The log events that are too old.
	 * </p>
	 * 
	 * @param tooOldLogEventEndIndex
	 *            The log events that are too old.
	 */

	public void setTooOldLogEventEndIndex(Integer tooOldLogEventEndIndex) {
		this.tooOldLogEventEndIndex = tooOldLogEventEndIndex;
	}

	/**
	 * <p>
	 * The log events that are too old.
	 * </p>
	 * 
	 * @return The log events that are too old.
	 */

	public Integer getTooOldLogEventEndIndex() {
		return this.tooOldLogEventEndIndex;
	}

	/**
	 * <p>
	 * The log events that are too old.
	 * </p>
	 * 
	 * @param tooOldLogEventEndIndex
	 *            The log events that are too old.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public RejectedLogEventsInfo withTooOldLogEventEndIndex(
			Integer tooOldLogEventEndIndex) {
		setTooOldLogEventEndIndex(tooOldLogEventEndIndex);
		return this;
	}

	/**
	 * <p>
	 * The expired log events.
	 * </p>
	 * 
	 * @param expiredLogEventEndIndex
	 *            The expired log events.
	 */

	public void setExpiredLogEventEndIndex(Integer expiredLogEventEndIndex) {
		this.expiredLogEventEndIndex = expiredLogEventEndIndex;
	}

	/**
	 * <p>
	 * The expired log events.
	 * </p>
	 * 
	 * @return The expired log events.
	 */

	public Integer getExpiredLogEventEndIndex() {
		return this.expiredLogEventEndIndex;
	}

	/**
	 * <p>
	 * The expired log events.
	 * </p>
	 * 
	 * @param expiredLogEventEndIndex
	 *            The expired log events.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public RejectedLogEventsInfo withExpiredLogEventEndIndex(
			Integer expiredLogEventEndIndex) {
		setExpiredLogEventEndIndex(expiredLogEventEndIndex);
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
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		if (getTooNewLogEventStartIndex() != null)
			sb.append("TooNewLogEventStartIndex: ")
					.append(getTooNewLogEventStartIndex()).append(",");
		if (getTooOldLogEventEndIndex() != null)
			sb.append("TooOldLogEventEndIndex: ")
					.append(getTooOldLogEventEndIndex()).append(",");
		if (getExpiredLogEventEndIndex() != null)
			sb.append("ExpiredLogEventEndIndex: ")
					.append(getExpiredLogEventEndIndex());
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof RejectedLogEventsInfo == false)
			return false;
		RejectedLogEventsInfo other = (RejectedLogEventsInfo) obj;
		if (other.getTooNewLogEventStartIndex() == null
				^ this.getTooNewLogEventStartIndex() == null)
			return false;
		if (other.getTooNewLogEventStartIndex() != null
				&& other.getTooNewLogEventStartIndex()
						.equals(this.getTooNewLogEventStartIndex()) == false)
			return false;
		if (other.getTooOldLogEventEndIndex() == null
				^ this.getTooOldLogEventEndIndex() == null)
			return false;
		if (other.getTooOldLogEventEndIndex() != null
				&& other.getTooOldLogEventEndIndex()
						.equals(this.getTooOldLogEventEndIndex()) == false)
			return false;
		if (other.getExpiredLogEventEndIndex() == null
				^ this.getExpiredLogEventEndIndex() == null)
			return false;
		if (other.getExpiredLogEventEndIndex() != null
				&& other.getExpiredLogEventEndIndex()
						.equals(this.getExpiredLogEventEndIndex()) == false)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashCode = 1;

		hashCode = prime * hashCode + ((getTooNewLogEventStartIndex() == null)
				? 0
				: getTooNewLogEventStartIndex().hashCode());
		hashCode = prime * hashCode + ((getTooOldLogEventEndIndex() == null)
				? 0
				: getTooOldLogEventEndIndex().hashCode());
		hashCode = prime * hashCode + ((getExpiredLogEventEndIndex() == null)
				? 0
				: getExpiredLogEventEndIndex().hashCode());
		return hashCode;
	}

	@Override
	public RejectedLogEventsInfo clone() {
		try {
			return (RejectedLogEventsInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(
					"Got a CloneNotSupportedException from Object.clone() "
							+ "even though we're Cloneable!",
					e);
		}
	}

}
