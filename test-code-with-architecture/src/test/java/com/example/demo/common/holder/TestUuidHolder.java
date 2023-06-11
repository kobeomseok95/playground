package com.example.demo.common.holder;

import com.example.demo.common.holder.code.CertificationCodeHolder;
import lombok.AllArgsConstructor;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

@AllArgsConstructor
@ActiveProfiles("test")
public class TestUuidHolder implements CertificationCodeHolder {
    private UUID uuid;

    @Override
    public String generate() {
        return uuid.toString();
    }
}
