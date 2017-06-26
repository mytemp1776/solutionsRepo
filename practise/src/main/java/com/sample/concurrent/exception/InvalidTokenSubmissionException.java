/**
 * 
 */
package com.sample.concurrent.exception;

/**
 * Exception thrown when attempt to submit invalid token is detected.
 * 
 * @author nagarro
 *
 */
public class InvalidTokenSubmissionException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidTokenSubmissionException(final String message) {
        super(message);
    }

    public InvalidTokenSubmissionException() {
        super();
    }
}
