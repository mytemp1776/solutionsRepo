/**
 * 
 */
package com.sample.concurrent.helper;

import org.springframework.stereotype.Component;

import com.sample.concurrent.exception.InvalidTokenSubmissionException;

/**
 * Token which has a property to know to which token counter it belongs.
 * 
 * @author nagarro
 *
 */
@Component
public class Token {

    /**
     * Token counter with which this token is related.
     */
    private final TokenCounter tokenCounter;

    /**
     * Constructor.
     * 
     * @param tokenCounter
     *            Token counter with which token is assocaited.
     */
    protected Token(final TokenCounter tokenCounter) {
        super();
        this.tokenCounter = tokenCounter;
    }

    /**
     * Notify all threads waiting on token counter to avail tokens.
     * 
     * @throws InvalidTokenSubmissionException
     *             If token submitted is invalid.
     */
    public void releaseToken() throws InvalidTokenSubmissionException {
        tokenCounter.submitToken(this);
    }
}
