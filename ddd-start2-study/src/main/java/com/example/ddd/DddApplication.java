package com.example.ddd;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@RequiredArgsConstructor
@EnableAsync
public class DddApplication implements CommandLineRunner {

    private final InitData initData;

    public static void main(String[] args) {
        SpringApplication.run(DddApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initData.postConstruct();
    }
}
