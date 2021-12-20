package com.example.effectivejava.chapter03.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Item13Test {

    @Test
    @DisplayName("단순하게 clone을 오버라이딩 한 경우, 똑같은 참조 주소의 elements 참행")
    void ex1() throws Exception {
        Stack stack = new Stack();
        stack.push("test");
        stack.push("test");
        stack.push("test");

        Stack clone = (Stack) stack.clone();

        System.out.println(stack.getSize());
        System.out.println(clone.getSize());

        stack.pop();
        stack.pop();
        System.out.println(stack.getSize());
        System.out.println(clone.getSize());
    }

    @Test
    @DisplayName("상속 관계에서의 clone")
    void ex2() throws Exception {
        Sub sub = new Sub();
        assertAll(
                () -> assertThat(sub.type).isEqualTo("super"),
                () -> {
                    Sub clone = sub.clone();
                    assertThat(sub.type).isEqualTo("sub");
                }
        );
    }
}
