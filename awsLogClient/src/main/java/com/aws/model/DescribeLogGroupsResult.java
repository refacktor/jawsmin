package com.aws.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/logs-2014-03-28/DescribeLogGroups" target="_top">AWS API
 *      Documentation</a>
 */
public class DescribeLogGroupsResult implements Serializable, Cloneable {

    /**
     * <p>
     * The log groups.
     * </p>
     * <p>
     * If the <code>retentionInDays</code> value if not included for a log group, then that log group is set to have its
     * events never expire.
     * </p>
     */
    private ArrayList<LogGroup> logGroups;

    private String nextToken;

    /**
     * <p>
     * The log groups.
     * </p>
     * <p>
     * If the <code>retentionInDays</code> value if not included for a log group, then that log group is set to have its
     * events never expire.
     * </p>
     * 
     * @return The log groups.</p>
     *         <p>
     *         If the <code>retentionInDays</code> value if not included for a log group, then that log group is set to
     *         have its events never expire.
     */

    public java.util.List<LogGroup> getLogGroups() {
        if (logGroups == null) {
            logGroups = new ArrayList<LogGroup>();
        }
        return logGroups;
    }

    /**
     * <p>
     * The log groups.
     * </p>
     * <p>
     * If the <code>retentionInDays</code> value if not included for a log group, then that log group is set to have its
     * events never expire.
     * </p>
     * 
     * @param logGroups
     *        The log groups.</p>
     *        <p>
     *        If the <code>retentionInDays</code> value if not included for a log group, then that log group is set to
     *        have its events never expire.
     */

    public void setLogGroups(java.util.Collection<LogGroup> logGroups) {
        if (logGroups == null) {
            this.logGroups = null;
            return;
        }

        this.logGroups = new ArrayList<LogGroup>(logGroups);
    }

    /**
     * <p>
     * The log groups.
     * </p>
     * <p>
     * If the <code>retentionInDays</code> value if not included for a log group, then that log group is set to have its
     * events never expire.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setLogGroups(java.util.Collection)} or {@link #withLogGroups(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     * 
     * @param logGroups
     *        The log groups.</p>
     *        <p>
     *        If the <code>retentionInDays</code> value if not included for a log group, then that log group is set to
     *        have its events never expire.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DescribeLogGroupsResult withLogGroups(LogGroup... logGroups) {
        if (this.logGroups == null) {
            setLogGroups(new ArrayList<LogGroup>(logGroups.length));
        }
        for (LogGroup ele : logGroups) {
            this.logGroups.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * The log groups.
     * </p>
     * <p>
     * If the <code>retentionInDays</code> value if not included for a log group, then that log group is set to have its
     * events never expire.
     * </p>
     * 
     * @param logGroups
     *        The log groups.</p>
     *        <p>
     *        If the <code>retentionInDays</code> value if not included for a log group, then that log group is set to
     *        have its events never expire.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DescribeLogGroupsResult withLogGroups(java.util.Collection<LogGroup> logGroups) {
        setLogGroups(logGroups);
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
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DescribeLogGroupsResult withNextToken(String nextToken) {
        setNextToken(nextToken);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getLogGroups() != null)
            sb.append("LogGroups: ").append(getLogGroups()).append(",");
        if (getNextToken() != null)
            sb.append("NextToken: ").append(getNextToken());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DescribeLogGroupsResult == false)
            return false;
        DescribeLogGroupsResult other = (DescribeLogGroupsResult) obj;
        if (other.getLogGroups() == null ^ this.getLogGroups() == null)
            return false;
        if (other.getLogGroups() != null && other.getLogGroups().equals(this.getLogGroups()) == false)
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

        hashCode = prime * hashCode + ((getLogGroups() == null) ? 0 : getLogGroups().hashCode());
        hashCode = prime * hashCode + ((getNextToken() == null) ? 0 : getNextToken().hashCode());
        return hashCode;
    }

    @Override
    public DescribeLogGroupsResult clone() {
        try {
            return (DescribeLogGroupsResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
