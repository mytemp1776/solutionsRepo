package com.sample.concurrent.delegator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sample.concurrent.async.FooAsyncTask;

@Component
public class AsyncTaskScheduler {

    @Autowired
    FooAsyncTask fooTask;

    @Scheduled(cron = "${scheduler.timeInterval}")
    void scheduleAsyncTask() {
        try {
            fooTask.executeAsyncTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
