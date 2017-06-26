package com.sample.concurrent.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sample.concurrent.exception.InvalidTokenSubmissionException;
import com.sample.concurrent.helper.Token;
import com.sample.concurrent.helper.TokenCounter;

/**
 * Async task
 * 
 * @author pbansal
 *
 */
@Component
public class FooAsyncTask {

    @Autowired
    BarAsyncTask barAsyncTask;

    @Async("FooPool")
    public void executeAsyncTask() throws InterruptedException {
        TokenCounter tokenCounter = TokenCounter.build(5);
        System.out.println(Thread.currentThread().getName() + " Foo async task started");
        for (int bartaskNumber = 1; bartaskNumber <= 10; bartaskNumber++) {
            Token taskToken = tokenCounter.getToken();
            try {
                barAsyncTask.executeAsyncTask(taskToken, bartaskNumber, Thread.currentThread().getName());
            } catch (InvalidTokenSubmissionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Foo async task finished");
    }
}
