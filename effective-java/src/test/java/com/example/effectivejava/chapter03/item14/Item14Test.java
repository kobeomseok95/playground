package com.example.effectivejava.chapter03.item14;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Item14Test {

    @Test
    void test() throws Exception {
        LocalDateTime NOW = LocalDateTime.now();

        ExChild ex1 = new ExChild(1L, NOW);
        ExChild ex2 = new ExChild(1L, NOW);

        log.info("name, age = {}, {}", ex1.getName(), ex1.getAge());
        assertEquals(ex1, ex2);
    }
}
