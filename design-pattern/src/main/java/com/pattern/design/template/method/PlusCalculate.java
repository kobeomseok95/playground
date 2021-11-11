package com.pattern.design.template.method;

import org.springframework.stereotype.Component;

@Component
public class PlusCalculate extends AbstractCalculate{

    @Override
    protected int calculate(int a, String cmd, int b) {
        if (cmd.equals("+")) {
            return a + b;
        }
        throw new IllegalArgumentException("더하기가 아닙니다!");
    }
}
