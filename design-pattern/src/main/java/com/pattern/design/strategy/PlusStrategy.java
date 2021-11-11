package com.pattern.design.strategy;

import org.springframework.stereotype.Component;

public class PlusStrategy implements CalculateStrategy{

    @Override
    public int calculate(int a, String cmd, int b) {
        if (cmd.equals("+")) {
            return a + b;
        }
        throw new IllegalArgumentException("더하기가 아닙니다!");
    }
}
