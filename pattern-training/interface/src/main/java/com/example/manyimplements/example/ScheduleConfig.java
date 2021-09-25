package com.example.manyimplements.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.LocalTime;

//@EnableScheduling
//@Configuration
public class ScheduleConfig {

//    @Scheduled(cron = "0 0/1 * * * *")
    public void test() {
        System.out.println(LocalTime.now());
        System.out.println("스케줄링 체크하기" + LocalDateTime.now());
    }
}
