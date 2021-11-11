package com.example.advanced.strategy;

import com.example.advanced.strategy.code.strategy.ContextV1;
import com.example.advanced.strategy.code.strategy.Strategy;
import com.example.advanced.strategy.code.strategy.StrategyLogic1;
import com.example.advanced.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context = new ContextV1(strategyLogic1);
        context.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        context = new ContextV1(strategyLogic2);
        context.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategy = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 실행");
            }
        };

        ContextV1 context = new ContextV1(strategy);
        context.execute();
    }

    @Test
    void strategyV3() {
        ContextV1 context = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 실행");
            }
        });
        context.execute();
    }

    @Test
    void strategyV4() {
        ContextV1 context = new ContextV1(() -> log.info("람다 비즈니스 로직 실행"));
        context.execute();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("==================비즈니스 로직 1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("==================비즈니스 로직 2 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
