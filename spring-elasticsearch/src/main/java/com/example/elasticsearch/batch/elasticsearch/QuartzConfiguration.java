package com.example.elasticsearch.batch.elasticsearch;

import com.example.elasticsearch.batch.test.TestScheduleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetail elasticsearchQuartzJobDetail() {
        return JobBuilder.newJob(BatchScheduleJob.class)
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger elasticsearchJobTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(15).repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(elasticsearchQuartzJobDetail())
                .withSchedule(simpleScheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail testQuartzJobDetail() {
        return JobBuilder.newJob(TestScheduleJob.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger testJobTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(1).repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(testQuartzJobDetail())
                .withSchedule(simpleScheduleBuilder)
                .build();
    }
}
