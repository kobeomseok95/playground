package com.example.elasticsearch.batch.elasticsearch;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class BatchScheduleJob extends QuartzJobBean {

    private final Job elasticsearchSyncJob;
    private final JobExplorer jobExplorer;
    private final JobLauncher jobLauncher;

    public BatchScheduleJob(@Qualifier("elasticsearchSyncJob") Job elasticsearchSyncJob,
                            JobExplorer jobExplorer, JobLauncher jobLauncher) {
        this.elasticsearchSyncJob = elasticsearchSyncJob;
        this.jobExplorer = jobExplorer;
        this.jobLauncher = jobLauncher;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobParameters jobParameters = new JobParametersBuilder(this.jobExplorer)
                .getNextJobParameters(this.elasticsearchSyncJob)
                .toJobParameters();
        try {
            this.jobLauncher.run(elasticsearchSyncJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
