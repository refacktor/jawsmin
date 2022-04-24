package org.jawsmin.model;

import java.io.Serializable;
import java.util.HashMap;

import org.jawsmin.json.Json;
import org.jawsmin.json.JsonObject;

/**
 * 
 * @see <a href=
 *      "http://docs.aws.amazon.com/goto/WebAPI/logs-2014-03-28/CreateLogGroup"
 *      target="_top">AWS API Documentation</a>
 */

public class CreateLogGroupRequest implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <p>
	 * The name of the log group.
	 * </p>
	 */
	private String logGroupName;
	/**
	 * <p>
	 * The Amazon Resource Name (ARN) of the CMK to use when encrypting log
	 * data. For more information, see <a href=
	 * "https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Amazon
	 * Resource Names - AWS Key Management Service (AWS KMS)</a>.
	 * </p>
	 */
	private String kmsKeyId;
	/**
	 * <p>
	 * The key-value pairs to use for the tags.
	 * </p>
	 */
	private HashMap<String, String> tags;

	/**
	 * Default constructor for CreateLogGroupRequest object. Callers should use
	 * the setter or fluent setter (with...) methods to initialize the object
	 * after creating it.
	 */
	public CreateLogGroupRequest() {
	}

	/**
	 * Constructs a new CreateLogGroupRequest object. Callers should use the
	 * setter or fluent setter (with...) methods to initialize any additional
	 * object members.
	 * 
	 * @param logGroupName
	 *            The name of the log group.
	 */
	public CreateLogGroupRequest(String logGroupName) {
		setLogGroupName(logGroupName);
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

	public CreateLogGroupRequest withLogGroupName(String logGroupName) {
		setLogGroupName(logGroupName);
		return this;
	}

	/**
	 * <p>
	 * The Amazon Resource Name (ARN) of the CMK to use when encrypting log
	 * data. For more information, see <a href=
	 * "https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Amazon
	 * Resource Names - AWS Key Management Service (AWS KMS)</a>.
	 * </p>
	 * 
	 * @param kmsKeyId
	 *            The Amazon Resource Name (ARN) of the CMK to use when
	 *            encrypting log data. For more information, see <a href=
	 *            "https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Amazon
	 *            Resource Names - AWS Key Management Service (AWS KMS)</a>.
	 */

	public void setKmsKeyId(String kmsKeyId) {
		this.kmsKeyId = kmsKeyId;
	}

	/**
	 * <p>
	 * The Amazon Resource Name (ARN) of the CMK to use when encrypting log
	 * data. For more information, see <a href=
	 * "https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Amazon
	 * Resource Names - AWS Key Management Service (AWS KMS)</a>.
	 * </p>
	 * 
	 * @return The Amazon Resource Name (ARN) of the CMK to use when encrypting
	 *         log data. For more information, see <a href=
	 *         "https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Amazon
	 *         Resource Names - AWS Key Management Service (AWS KMS)</a>.
	 */

	public String getKmsKeyId() {
		return this.kmsKeyId;
	}

	/**
	 * <p>
	 * The Amazon Resource Name (ARN) of the CMK to use when encrypting log
	 * data. For more information, see <a href=
	 * "https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Amazon
	 * Resource Names - AWS Key Management Service (AWS KMS)</a>.
	 * </p>
	 * 
	 * @param kmsKeyId
	 *            The Amazon Resource Name (ARN) of the CMK to use when
	 *            encrypting log data. For more information, see <a href=
	 *            "https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Amazon
	 *            Resource Names - AWS Key Management Service (AWS KMS)</a>.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public CreateLogGroupRequest withKmsKeyId(String kmsKeyId) {
		setKmsKeyId(kmsKeyId);
		return this;
	}

	/**
	 * <p>
	 * The key-value pairs to use for the tags.
	 * </p>
	 * 
	 * @return The key-value pairs to use for the tags.
	 */

	public java.util.Map<String, String> getTags() {
		if (tags == null) {
			tags = new HashMap<String, String>();
		}
		return tags;
	}

	/**
	 * <p>
	 * The key-value pairs to use for the tags.
	 * </p>
	 * 
	 * @param tags
	 *            The key-value pairs to use for the tags.
	 */

	public void setTags(java.util.Map<String, String> tags) {
		this.tags = tags == null ? null : new HashMap<String, String>(tags);
	}

	/**
	 * <p>
	 * The key-value pairs to use for the tags.
	 * </p>
	 * 
	 * @param tags
	 *            The key-value pairs to use for the tags.
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public CreateLogGroupRequest withTags(java.util.Map<String, String> tags) {
		setTags(tags);
		return this;
	}

	/**
	 * Add a single Tags entry
	 *
	 * @see CreateLogGroupRequest#withTags
	 * @returns a reference to this object so that method calls can be chained
	 *          together.
	 */

	public CreateLogGroupRequest addTagsEntry(String key, String value) {
		if (null == this.tags) {
			this.tags = new HashMap<String, String>();
		}
		if (this.tags.containsKey(key))
			throw new IllegalArgumentException(
					"Duplicated keys (" + key.toString() + ") are provided.");
		this.tags.put(key, value);
		return this;
	}

	/**
	 * Removes all the entries added into Tags.
	 *
	 * @return Returns a reference to this object so that method calls can be
	 *         chained together.
	 */

	public CreateLogGroupRequest clearTagsEntries() {
		this.tags = null;
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
		if (kmsKeyId != null)
			modelJson.set("kmsKeyId", this.kmsKeyId);
		if (tags != null) {
			JsonObject tgs = Json.object();
			tags.entrySet().stream().forEach(entry -> {

				tgs.set(entry.getKey().trim(), entry.getValue());

			});

			modelJson.set("tags", tgs);
		}

		return modelJson.toString().trim();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof CreateLogGroupRequest == false)
			return false;
		CreateLogGroupRequest other = (CreateLogGroupRequest) obj;
		if (other.getLogGroupName() == null ^ this.getLogGroupName() == null)
			return false;
		if (other.getLogGroupName() != null && other.getLogGroupName()
				.equals(this.getLogGroupName()) == false)
			return false;
		if (other.getKmsKeyId() == null ^ this.getKmsKeyId() == null)
			return false;
		if (other.getKmsKeyId() != null
				&& other.getKmsKeyId().equals(this.getKmsKeyId()) == false)
			return false;
		if (other.getTags() == null ^ this.getTags() == null)
			return false;
		if (other.getTags() != null
				&& other.getTags().equals(this.getTags()) == false)
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
		hashCode = prime * hashCode
				+ ((getKmsKeyId() == null) ? 0 : getKmsKeyId().hashCode());
		hashCode = prime * hashCode
				+ ((getTags() == null) ? 0 : getTags().hashCode());
		return hashCode;
	}

	@Override
	public CreateLogGroupRequest clone() throws CloneNotSupportedException {
		return (CreateLogGroupRequest) super.clone();
	}

}
