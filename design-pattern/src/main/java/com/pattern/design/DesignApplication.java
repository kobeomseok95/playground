package com.pattern.design;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesignApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Client client = new Client();
        client.main();
    }
}
