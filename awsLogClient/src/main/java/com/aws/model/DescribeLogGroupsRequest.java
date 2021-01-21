package com.aws.model;

import java.io.Serializable;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

/**
 * 
 * @see <a href=
 *      "http://docs.aws.amazon.com/goto/WebAPI/logs-2014-03-28/DescribeLogGroups"
 *      target="_top">AWS API Documentation</a>
 */
public class DescribeLogGroupsRequest implements Serializable, Cloneable {

	/**
	 * <p>
	 * The prefix to match.
	 * </p>
	 */
	private String logGroupNamePrefix;
	/**
	 * <p>
	 * The token for the next set of items to return. (You received this token
	 * from a previous call.)
	 * </p>
	 */
	private String nextToken;
	/**
	 * <p>
	 * The maximum number of items returned. If you don't specify a value, the
	 * default is up to 50 items.
	 * </p>
	 */
	private Integer limit;

	/**
	 * <p>
	 * The prefix to match.
	 * </p>
	 * 
	 * @param logGroupNamePrefix
	 *            The prefix to match.
	 */

	public void setLogGroupNamePrefix(String logGroupNamePrefix) {
		this.logGroupNamePrefix = logGroupNamePrefix;
	}

	/**
	 * <p>
	 * The prefix to match.
	 * </p>
	 * 
	 * @return The prefix to match.
	 */

	public String getLogGroupNamePrefix() {
		return this.logGroupNamePrefix;
	}

	/**
	 * <p>
	 * The prefix to match.
	 * </p>
	 * 
	 * @param logGroupNamePrefix
	 *            The prefix to match.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public DescribeLogGroupsRequest withLogGroupNamePrefix(
			String logGroupNamePrefix) {
		setLogGroupNamePrefix(logGroupNamePrefix);
		return this;
	}

	/**
	 * <p>
	 * The token for the next set of items to return. (You received this token
	 * from a previous call.)
	 * </p>
	 * 
	 * @param nextToken
	 *            The token for the next set of items to return. (You received
	 *            this token from a previous call.)
	 */

	public void setNextToken(String nextToken) {
		this.nextToken = nextToken;
	}

	/**
	 * <p>
	 * The token for the next set of items to return. (You received this token
	 * from a previous call.)
	 * </p>
	 * 
	 * @return The token for the next set of items to return. (You received this
	 *         token from a previous call.)
	 */

	public String getNextToken() {
		return this.nextToken;
	}

	/**
	 * <p>
	 * The token for the next set of items to return. (You received this token
	 * from a previous call.)
	 * </p>
	 * 
	 * @param nextToken
	 *            The token for the next set of items to return. (You received
	 *            this token from a previous call.)
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public DescribeLogGroupsRequest withNextToken(String nextToken) {
		setNextToken(nextToken);
		return this;
	}

	/**
	 * <p>
	 * The maximum number of items returned. If you don't specify a value, the
	 * default is up to 50 items.
	 * </p>
	 * 
	 * @param limit
	 *            The maximum number of items returned. If you don't specify a
	 *            value, the default is up to 50 items.
	 */

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * <p>
	 * The maximum number of items returned. If you don't specify a value, the
	 * default is up to 50 items.
	 * </p>
	 * 
	 * @return The maximum number of items returned. If you don't specify a
	 *         value, the default is up to 50 items.
	 */

	public Integer getLimit() {
		return this.limit;
	}

	/**
	 * <p>
	 * The maximum number of items returned. If you don't specify a value, the
	 * default is up to 50 items.
	 * </p>
	 * 
	 * @param limit
	 *            The maximum number of items returned. If you don't specify a
	 *            value, the default is up to 50 items.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public DescribeLogGroupsRequest withLimit(Integer limit) {
		setLimit(limit);
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
		if (logGroupNamePrefix != null)
			modelJson.set("logGroupNamePrefix", this.logGroupNamePrefix);
		if (nextToken != null)
			modelJson.set("nextToken", this.nextToken);
		if (limit != null)
			modelJson.set("limit", this.limit);

		return modelJson.toString();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof DescribeLogGroupsRequest == false)
			return false;
		DescribeLogGroupsRequest other = (DescribeLogGroupsRequest) obj;
		if (other.getLogGroupNamePrefix() == null
				^ this.getLogGroupNamePrefix() == null)
			return false;
		if (other.getLogGroupNamePrefix() != null
				&& other.getLogGroupNamePrefix()
						.equals(this.getLogGroupNamePrefix()) == false)
			return false;
		if (other.getNextToken() == null ^ this.getNextToken() == null)
			return false;
		if (other.getNextToken() != null
				&& other.getNextToken().equals(this.getNextToken()) == false)
			return false;
		if (other.getLimit() == null ^ this.getLimit() == null)
			return false;
		if (other.getLimit() != null
				&& other.getLimit().equals(this.getLimit()) == false)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashCode = 1;

		hashCode = prime * hashCode + ((getLogGroupNamePrefix() == null)
				? 0
				: getLogGroupNamePrefix().hashCode());
		hashCode = prime * hashCode
				+ ((getNextToken() == null) ? 0 : getNextToken().hashCode());
		hashCode = prime * hashCode
				+ ((getLimit() == null) ? 0 : getLimit().hashCode());
		return hashCode;
	}

	@Override
	public DescribeLogGroupsRequest clone() throws CloneNotSupportedException {
		return (DescribeLogGroupsRequest) super.clone();
	}

}
