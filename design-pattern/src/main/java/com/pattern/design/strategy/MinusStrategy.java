package com.pattern.design.strategy;

import org.springframework.stereotype.Component;

public class MinusStrategy implements CalculateStrategy{
    @Override
    public int calculate(int a, String cmd, int b) {
        if (cmd.equals("-")) {
            return a - b;
        }
        throw new IllegalArgumentException("빼기가 아닙니다!");
    }
}
