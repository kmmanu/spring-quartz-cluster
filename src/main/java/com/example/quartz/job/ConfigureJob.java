package com.example.quartz.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.CronScheduleBuilder.cronSchedule;

@Configuration
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class ConfigureJob {

    @Bean
    public JobDetail jobADetails() {
        return JobBuilder.newJob(AJob.class)
                .withIdentity("sampleJob1")
                .storeDurably()
                .build();
    }

    @Bean
    public JobDetail jobBDetails() {
        return JobBuilder.newJob(BJob.class)
                .withIdentity("sampleJob2")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail jobADetails) {
        return TriggerBuilder.newTrigger()
                .forJob(jobADetails)
                .withIdentity("sampleTrigger1")
                .withSchedule(cronSchedule("0/2 * * ? * * *")) // Run every 2 seconds
                .build();
    }

    @Bean
    public Trigger jobBTrigger(JobDetail jobBDetails) {
        return TriggerBuilder.newTrigger()
                .forJob(jobBDetails)
                .withIdentity("sampleTrigger2")
                .withSchedule(cronSchedule("0/5 * * ? * * *")) // Run every 5 seconds
                .build();
    }


}
