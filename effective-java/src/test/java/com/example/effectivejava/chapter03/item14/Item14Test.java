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
        CommonFields commonFields1 = new CommonFields("test", 20);
        CommonFields commonFields2 = new CommonFields("test", 20);

        ExChild ex1 = new ExChild(1L, NOW, commonFields1);
        ExParent ex2 = new ExChild(1L, NOW, commonFields2);

        assertEquals(ex1, ex2);
    }
}
