package com.pattern.design.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
public class Context {
    public void execute(int a, String cmd, int b, CalculateStrategy strategy) {
        log.info("{} {} {}", a, cmd, b);
        int answer = strategy.calculate(a, cmd, b);
        log.info("결과는 {}입니다.", answer);
    }
}
