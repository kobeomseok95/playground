package com.example.jpashop.domain;

import com.example.jpashop.domain.item.Album;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    @DisplayName("계층형 카테고리 생성")
    void addParent() throws Exception {

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

    @Test
    @DisplayName("CategoryItem 생성")
    void addCategoryItem() throws Exception {

        // given
        Category category = Category.builder().build();
        CategoryItem categoryItem = CategoryItem.builder().build();

        // when
        category.addCategoryItem(categoryItem);
        category.addCategoryItem(categoryItem);

        // then
        assertTrue(category.getCategoryItems().contains(categoryItem));
        assertEquals(category.getCategoryItems().size(), 1);
    }
}
