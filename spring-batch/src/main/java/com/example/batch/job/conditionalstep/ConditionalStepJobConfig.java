package com.example.batch.job.conditionalstep;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ConditionalStepJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job conditionalStepJob(
            Step startStep,
            Step allStep,
            Step failStep,
            Step completedStep
    ) {
        return jobBuilderFactory
                .get("conditionalStepJob")
                .incrementer(new RunIdIncrementer())
                .start(startStep)
                .on("FAILED").to(failStep)
                .from(startStep)
                .on("COMPLETED").to(completedStep)
                .from(startStep)
                .on("*").to(allStep)
                .end()
                .build();
    }

    @JobScope
    @Bean
    public Step startStep() {
        return stepBuilderFactory
                .get("startStep")
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("start step");
                    return RepeatStatus.FINISHED;
//                    throw new IllegalArgumentException("일부러 실패를 내본다.");
//                    System.out.println("start step");
//                    return RepeatStatus.CONTINUABLE;
                }))
                .build();
    }

    @JobScope
    @Bean
    public Step allStep() {
        return stepBuilderFactory
                .get("allStep")
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("all step");
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }

    @JobScope
    @Bean
    public Step failStep() {
        return stepBuilderFactory
                .get("failStep")
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("fail step");
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }

    @JobScope
    @Bean
    public Step completedStep() {
        return stepBuilderFactory
                .get("completedStep")
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("completed step");
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }
}
