package com.example.elasticsearch.batch.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
//@Configuration
//@EnableBatchProcessing
@RequiredArgsConstructor
public class TestJobConfig {

    private static final String TEST_JOB = "testJob";
    private static final String TEST_STEP = "testStep";

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job testJob() throws Exception {
        return jobBuilderFactory.get(TEST_JOB)
                .start(testStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    @JobScope
    public Step testStep() {
        return stepBuilderFactory.get(TEST_STEP)
                .tasklet(((contribution, chunkContext) -> {
                    log.info("=========================== 1분마다 실행되는 JOB의 STEP");
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }
}
