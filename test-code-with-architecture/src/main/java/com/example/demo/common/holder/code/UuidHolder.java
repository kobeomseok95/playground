package com.example.demo.common.holder.code;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidHolder implements CertificationCodeHolder {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
