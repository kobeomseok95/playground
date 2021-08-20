package com.example.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.ManagedBean;
import javax.management.MXBean;
import java.util.Random;

@Slf4j
@EnableBatchProcessing
@SpringBootApplication
@RequiredArgsConstructor
public class BatchApplication {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final SkipCheckingListener skipCheckingListener;

    @Bean
    public Job job() {
//        return jobBuilderFactory.get("conditionalJob")
//                .start(conditionalStep1())
//                .on("FAILED") // Catch할 ExitStatus 지정
//                .to(conditionalStep3()) // Catch될 경우 지정한 next step으로 이동
//                .on("*").end()
//                .from(conditionalStep1()) // 일종의 이벤트 리스너 역할
//                .on("*")
//                .to(conditionalStep2())
//                .next(conditionalStep3())
//                .on("*").end()
//                .end()
//                .build();
//        return jobBuilderFactory.get("statusJob")
//                .start(conditionalStep1())
//                        .on("FAILED").end()
//                .from(conditionalStep1()) // 일종의 이벤트 리스너 역할
//                        .on("COMPLETED WITH SKIPS")
//                        .to(conditionalStep3())
//                        .on("*").end()
//                .from(conditionalStep1())
//                        .on("*")
//                        .to(conditionalStep2())
//                        .on("*")
//                        .to(conditionalStep3()).end()
//                .build();

        return jobBuilderFactory.get("deciderJob")
                .start(startStep())
                .next(jobExecutionDecider())
                .from(jobExecutionDecider())
                        .on("ODD")
                        .to(oddStep())
                .from(jobExecutionDecider())
                        .on("EVEN")
                        .to(evenStep())
                .end()
                .build();
    }

    @Bean
    public Step startStep() {
        return stepBuilderFactory.get("startStep")
                .tasklet(((contribution, chunkContext) -> {
                    log.info("***** START!!");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public Step oddStep() {
        return stepBuilderFactory.get("oddStep")
                .tasklet(((contribution, chunkContext) -> {
                    log.info("***** 홀수입니다");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public Step evenStep() {
        return stepBuilderFactory.get("evenStep")
                .tasklet(((contribution, chunkContext) -> {
                    log.info("***** 짝수입니다");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public JobExecutionDecider jobExecutionDecider() {
        return new OddDecider();
    }

    public static class OddDecider implements JobExecutionDecider{

        @Override
        public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
            Random random = new Random();

            int number = random.nextInt(50) + 1;
            log.info("***** 숫자는 {}", number);

            return checkOddEvenAndReturnDecider(number);
        }

        private FlowExecutionStatus checkOddEvenAndReturnDecider(int number) {
            return number % 2 == 0
                    ? new FlowExecutionStatus("EVEN")
                    : new FlowExecutionStatus("ODD");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

}
