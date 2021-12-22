package com.example.jacoco.modules;

import com.example.jacoco.modules.JavaFoo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaFooTest {

    private JavaFoo javaFoo = new JavaFoo();

    @Test
    void test1() {
        assertEquals(javaFoo.hello("펭"), "하");
    }

    @Test
    void test2() {
        assertEquals(javaFoo.hello("hello"), "world");
    }

    @Test
    void test3() {
        assertEquals(javaFoo.hello("ex"), "None");
    }

    @Test
    void test4() {
        javaFoo.callMe();
    }
}