package com.example.jpashop.domain;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.dummy.OrderDummy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {

    OrderDummy orderDummy = new OrderDummy();

    @Test
    @DisplayName("주문 생성")
    void createOrder() throws Exception {

        // given
        Member member = orderDummy.createOrderMember();
        Delivery delivery = orderDummy.createDelivery();
        List<OrderItem> orderItems = orderDummy.createOrderItems();

        // when
        Order order = Order.createOrder(member, delivery, orderItems);

        // then, 아이템 재고 수량 감소까지 확인
        assertAll(
                () -> assertEquals(order.getStatus(), OrderStatus.ORDER),
                () -> assertEquals(order.getOrderItems().size(), 3),
                () -> assertEquals(order.getMember().getName(), "고범석"),
                () -> orderItems.forEach(o -> assertEquals(o.getOrder(), order)));
    }

    @Test
    @DisplayName("주문 취소")
    void cancelOrder() throws Exception {

        // given
        Album album = Album.builder().stockQuantity(50).build();
        Book book = Book.builder().stockQuantity(40).build();
        Order ordered = orderDummy.createOrdered(album, book);

        // when
        ordered.cancelOrder();

        // then
        assertAll(
                () -> assertEquals(ordered.getStatus(), OrderStatus.CANCEL),
                () -> assertEquals(ordered.getDelivery().getStatus(), DeliveryStatus.CANCEL),
                () -> assertEquals(album.getStockQuantity(), 60),
                () -> assertEquals(book.getStockQuantity(), 70));
    }
}
