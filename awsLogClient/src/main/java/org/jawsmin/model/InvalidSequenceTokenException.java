package org.jawsmin.model;

/**
 * <p>
 * The sequence token is not valid. You can get the correct sequence token in
 * the <code>expectedSequenceToken</code> field in the
 * <code>InvalidSequenceTokenException</code> message.
 * </p>
 */
public class InvalidSequenceTokenException extends AWSLogsException {
	private static final long serialVersionUID = 1L;

	private String expectedSequenceToken;

	/**
	 * Constructs a new InvalidSequenceTokenException with the specified error
	 * message.
	 *
	 * @param message
	 *            Describes the error encountered.
	 */
	public InvalidSequenceTokenException(String message) {
		super(message);
	}

	/**
	 * @param expectedSequenceToken
	 */

	public void setExpectedSequenceToken(String expectedSequenceToken) {
		this.expectedSequenceToken = expectedSequenceToken;
	}

	/**
	 * @return
	 */

	public String getExpectedSequenceToken() {
		return this.expectedSequenceToken;
	}

	/**
	 * @param expectedSequenceToken
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public InvalidSequenceTokenException withExpectedSequenceToken(
			String expectedSequenceToken) {
		setExpectedSequenceToken(expectedSequenceToken);
		return this;
	}

}
