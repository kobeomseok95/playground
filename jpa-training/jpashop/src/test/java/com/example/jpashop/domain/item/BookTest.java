package com.example.jpashop.domain.item;

import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.dummy.ItemDummy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    ItemDummy itemDummy = new ItemDummy();

    @Test
    @DisplayName("책 수정")
    void updateBook() throws Exception {

        // given
        Book book = itemDummy.createBook();
        ItemDto.BookDto request = ItemDto.BookDto.builder()
                .name("수정").price(10).itemType(ItemDto.ItemType.BOOK)
                .stockQuantity(10).author("수정").isbn("수정").build();

        // when
        book.updateBook(request);

        // then
        assertAll(
                () -> assertEquals(book.getName(), request.getName()),
                () -> assertEquals(book.getPrice(), request.getPrice()),
                () -> assertEquals(book.getStockQuantity(), request.getStockQuantity()),
                () -> assertEquals(book.getAuthor(), request.getAuthor()),
                () -> assertEquals(book.getIsbn(), request.getIsbn())
        );
    }
}
