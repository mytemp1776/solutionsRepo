package com.sample.concurrent.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sample.concurrent.exception.InvalidTokenSubmissionException;
import com.sample.concurrent.helper.Token;

/**
 * Async task
 * 
 * @author nagarro
 *
 */
@Component
public class BarAsyncTask {

    @Async("BarPool")
    public void executeAsyncTask(Token token, int taskNumber, String fooTaskName)
            throws InterruptedException, InvalidTokenSubmissionException {
        System.out.println(fooTaskName + " " + Thread.currentThread().getName() + " Bar async task number " + taskNumber
                + " started");
        Thread.sleep(1000);
        System.out.println(fooTaskName + " " + Thread.currentThread().getName() + " Bar async task number " + taskNumber
                + " finished");
        token.releaseToken();
    }
}
