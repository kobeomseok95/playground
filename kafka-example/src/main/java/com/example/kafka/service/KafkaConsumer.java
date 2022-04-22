package com.example.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user", groupId = "kafka-demo")
    public void consume(String message) {
        log.info("consume message = {}", message);
    }
}
