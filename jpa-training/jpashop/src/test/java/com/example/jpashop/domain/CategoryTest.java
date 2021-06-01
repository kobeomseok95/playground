package com.example.jpashop.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    @DisplayName("계층형 카테고리 생성")
    public void addParent() {

        // given
        Category parent = Category.builder().name("부모").id(1L).build();
        Category child = Category.builder().name("자식").id(2L).build();

        // when
        child.addParent(parent);

        // then
        assertAll(
                () -> assertTrue(parent.getChildren().contains(child)),
                () -> assertEquals(child.getParent(), parent));
    }
}
