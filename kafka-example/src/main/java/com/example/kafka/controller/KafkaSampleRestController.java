package com.example.kafka.controller;

import com.example.kafka.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class KafkaSampleRestController {

    private final KafkaProducer producer;

    @PostMapping("")
    public String sendMessage(@RequestBody MessageRequest messageRequest) {
        producer.sendMessage(messageRequest.getMessage());
        return "success";
    }
}
