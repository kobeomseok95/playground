package com.example.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.support.ListItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
//@RequiredArgsConstructor
public class BatchApplication {

//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job chunkBasedJob() {
//        return this.jobBuilderFactory.get("chunkBasedJob")
//                .start(chunkStep())
//                .build();
//    }
//
//    @Bean
//    public Step chunkStep() {
//        return this.stepBuilderFactory.get("chunkStep")
//                .<String, String>chunk(1000)
//                .reader(itemReader())
//                .writer(itemWriter())
//                .build();
//    }
//
//    @Bean
//    public ListItemReader<String> itemReader() {
//        List<String> items = new ArrayList<>(100000);
//        for(int i = 0; i < 100000; i++) {
//            items.add(UUID.randomUUID().toString());
//        }
//        return new ListItemReader<>(items);
//    }
//
//    @Bean
//    public ItemWriter<String> itemWriter() {
//        return items -> {
//            for (String item : items) {
//                System.out.println(">> current Item : " + item);
//            }
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

}
