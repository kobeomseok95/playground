package com.example.jpashop.domain.item;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.dummy.ItemDummy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    ItemDummy itemDummy = new ItemDummy();

    @Test
    @DisplayName("재고 증가")
    void addStock() throws Exception {

        // given
        Item item = itemDummy.createAlbum();

        // when
        item.addStock(200);

        // then
        assertEquals(400, item.getStockQuantity());
    }

    @Test
    @DisplayName("재고 감소")
    void removeStock() throws Exception {

        // given
        Item item = itemDummy.createAlbum();

        // when
        item.removeStock(100);

        // then
        assertEquals(100, item.getStockQuantity());
    }

    @Test
    @DisplayName("재고가 음수는 불가능")
    void removeStockException() throws Exception {

        // given
        Item item = itemDummy.createAlbum();

        // when, then
        assertThrows(IllegalStateException.class,
                () -> item.removeStock(201),
                "재고가 부족합니다.");
    }

    @Test
    @DisplayName("CategoryItem 생성")
    void addCategoryItem() throws Exception {

        // given
        Album album = Album.builder().build();
        CategoryItem categoryItem = CategoryItem.builder().build();

        // when
        album.addCategoryItem(categoryItem);
        album.addCategoryItem(categoryItem);

        // then
        assertTrue(album.getCategoryItems().contains(categoryItem));
        assertEquals(album.getCategoryItems().size(), 1);
    }
}