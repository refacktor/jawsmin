package com.aws.model;

import com.aws.exceptions.AmazonServiceException;

/**
 * Base exception for all service exceptions thrown by Amazon CloudWatch Logs
 */
public class AWSLogsException extends AmazonServiceException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new AWSLogsException with the specified error message.
     *
     * @param message
     *        Describes the error encountered.
     */
    public AWSLogsException(String message) {
        super(message);
    }

}
