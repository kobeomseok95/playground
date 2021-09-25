package com.example.awsec2s3practice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter @Setter @Component @ConfigurationProperties("spring.datasource")
public class DatabaseProperty {

    private String url;
    private List<Slave> slaveList;

    private String driverClassName;
    private String username;
    private String password;

    @Getter @Setter
    public static class Slave {
        private String name;
        private String url;
    }
}
