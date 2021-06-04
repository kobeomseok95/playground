package com.example.jpashop.domain;

import com.example.jpashop.domain.item.Item;
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
        Order ordered = orderDummy.createOrderedOrder();

        // when
        ordered.cancelOrder();

        // then
        assertEquals(ordered.getStatus(), OrderStatus.CANCEL);
    }
}
