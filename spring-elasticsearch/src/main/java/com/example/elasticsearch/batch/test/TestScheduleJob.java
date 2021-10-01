package com.example.elasticsearch.batch.test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestScheduleJob extends QuartzJobBean {

    private final Job testJob;
    private final JobExplorer jobExplorer;
    private final JobLauncher jobLauncher;

    public TestScheduleJob(@Qualifier("testJob") Job testJob, JobExplorer jobExplorer, JobLauncher jobLauncher) {
        this.testJob = testJob;
        this.jobExplorer = jobExplorer;
        this.jobLauncher = jobLauncher;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobParameters jobParameters = new JobParametersBuilder(this.jobExplorer)
                .getNextJobParameters(this.testJob)
                .toJobParameters();
        try {
            this.jobLauncher.run(testJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
