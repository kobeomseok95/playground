package com.example.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.CompositeJobParametersValidator;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.ManagedBean;
import javax.management.MXBean;
import java.util.Arrays;
import java.util.Random;

@Slf4j
@EnableBatchProcessing
@SpringBootApplication
@RequiredArgsConstructor
public class BatchApplication {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public CompositeJobParametersValidator validator() {
        CompositeJobParametersValidator validator = new CompositeJobParametersValidator();


        DefaultJobParametersValidator defaultJobParametersValidator = new DefaultJobParametersValidator(
                new String[] {"fileName"}, new String[] {"name"}
        );
        defaultJobParametersValidator.afterPropertiesSet();

        validator.setValidators(Arrays.asList(new ParameterValidator(),
                defaultJobParametersValidator));

        return validator;
    }

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("basicJob")
                .start(step1())
                .validator(validator())
                .build();
    }

    @Bean
    public Step step1() {
        return this.stepBuilderFactory.get("step1")
                .tasklet(helloWorldTasklet(null, null)).build();
    }

    // 늦은 바인딩 방식
    private Tasklet helloWorldTasklet(@Value("#{jobParameters['name']}") String name,
                                      @Value("#{jobParameters['fileName']}") String fileName) {
        return ((contribution, chunkContext) -> {
            System.out.println("***************name = " + name);
            System.out.println("***************fileName = " + fileName);
            return RepeatStatus.FINISHED;
        });
    }

    // chunkContext 에서 parameter 확인
//    private Tasklet helloWorldTasklet() {
//        return ((contribution, chunkContext) -> {
//            String parameterName = (String) chunkContext
//                    .getStepContext().getJobParameters().get("name");
//            log.info("**************** parameterName = {}", parameterName);
//            return RepeatStatus.FINISHED;
//        });
//    }

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

}
