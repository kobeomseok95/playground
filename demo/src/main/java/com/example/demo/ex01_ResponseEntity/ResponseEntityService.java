package com.example.demo.ex01_ResponseEntity;

import org.springframework.stereotype.Service;

@Service
public class ResponseEntityService {

    public User getUser() {
        return User.builder()
                .id(1L)
                .name("고범석")
                .city("서울시")
                .build();
    }
}
