package com.example.batch.job.multiplestep;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MultipleStepJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job multipleStepJob(
            Step step1,
            Step step2,
            Step step3
    ) {
        return jobBuilderFactory
                .get("multipleStepJob")
                .start(step1)
                .next(step2)
                .next(step3)
                .build();
    }

    @JobScope
    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("step1")
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("step1");
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }

    @JobScope
    @Bean
    public Step step2() {
        return stepBuilderFactory
                .get("step2")
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("step2");

                    ExecutionContext executionContext = chunkContext
                            .getStepContext()
                            .getStepExecution()
                            .getJobExecution()
                            .getExecutionContext();
                    executionContext.put("key", "here is step 2");

                    return RepeatStatus.FINISHED;
                }))
                .build();
    }

    @JobScope
    @Bean
    public Step step3() {
        return stepBuilderFactory
                .get("step3")
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("step3");

                    ExecutionContext executionContext = chunkContext
                            .getStepContext()
                            .getStepExecution()
                            .getJobExecution()
                            .getExecutionContext();
                    System.out.println(executionContext.get("key"));

                    return RepeatStatus.FINISHED;
                }))
                .build();
    }
}
