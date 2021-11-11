package com.pattern.design.template.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractCalculate {

    public void calc(int a, int b, String cmd) {
        log.info("{} {} {}", a, cmd, b);
        int answer = calculate(a, cmd, b);
        log.info("결과는 {}입니다.", answer);
    }

    protected abstract int calculate(int a, String cmd, int b);
}
