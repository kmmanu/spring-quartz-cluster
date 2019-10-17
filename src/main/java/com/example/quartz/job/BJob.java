package com.example.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

@Slf4j
public class BJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        log.info("Job b says hi !");
    }
}
