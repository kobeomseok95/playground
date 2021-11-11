package com.example.advanced.template;

import com.example.advanced.template.code.AbstractTemplate;
import com.example.advanced.template.code.SubClassLogic1;
import com.example.advanced.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate tmp1 = new SubClassLogic1();
        tmp1.execute();
        AbstractTemplate tmp2 = new SubClassLogic2();
        tmp2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate template = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("===============비즈니스 로직 익명 내부 클래스!");
            }
        };
        log.info("클래스 이름 = {}", template.getClass());
        template.execute();
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
