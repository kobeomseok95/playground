package com.example.awsec2s3practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AwsEc2S3PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsEc2S3PracticeApplication.class, args);
    }

}
