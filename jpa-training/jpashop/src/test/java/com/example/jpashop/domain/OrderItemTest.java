package com.example.jpashop.domain;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.OrderDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    @DisplayName("OrderItem 생성 및 주문 수량 확인")
    void createOrderItem() throws Exception {

        // given
        Album album = Album.builder().id(100L).stockQuantity(100).build();
        Book book = Book.builder().id(101L).stockQuantity(20).build();
        Book book2 = Book.builder().id(99L).stockQuantity(70).build();
        List<Item> sortedItems = List.of(album, book, book2).stream()
                .sorted(Comparator.comparing(Item::getId)).collect(toList());
        List<OrderDto.OrderItemDto> orderItemDtos = List.of(
                OrderDto.OrderItemDto.builder().itemId("99").count(30).build(),
                OrderDto.OrderItemDto.builder().itemId("100").count(10).build(),
                OrderDto.OrderItemDto.builder().itemId("101").count(10).build());

        // when
        List<OrderItem> orderItem = OrderItem.createOrderItem(orderItemDtos, sortedItems);

        // then
        assertAll(
                () -> assertEquals(album.getStockQuantity(), 90),
                () -> assertEquals(book.getStockQuantity(), 10),
                () -> assertEquals(book2.getStockQuantity(), 40));
    }
}