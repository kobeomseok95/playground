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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    @DisplayName("OrderItem 생성 및 주문 수량 확인")
    void createOrderItem() throws Exception {

        // given
        Album album = Album.builder().id(100L).stockQuantity(100).build();
        OrderDto.OrderItemDto orderItemDto = OrderDto.OrderItemDto.builder().itemId("100")
                .count(10).build();

        // when
        OrderItem orderItem = OrderItem.createOrderItem(album, orderItemDto);

        // then
        assertAll(
                () -> assertEquals(orderItem.getItem(), album),
                () -> assertEquals(90, album.getStockQuantity()));
    }
}