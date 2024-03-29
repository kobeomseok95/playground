package com.example.jpashop.dummy;

import com.example.jpashop.domain.*;
import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.Movie;

import java.util.Arrays;
import java.util.List;

public class OrderDummy {

    public Order createOrdered(Item item1, Item item2) {
        return Order.builder()
                .id(100L)
                .delivery(Delivery.builder().status(DeliveryStatus.READY).build())
                .orderItems(
                        List.of(OrderItem.builder().item(item1).count(10).build(),
                                OrderItem.builder().item(item2).count(30).build()
                )).status(OrderStatus.ORDER)
                .build();
    }

    public Member createOrderMember() {
        return Member.builder()
                .id(1L).name("고범석")
                .address(Address.builder()
                        .city("city").street("street").zipcode("zipcode")
                        .build()).build();
    }

    public Delivery createDelivery() {
        return Delivery.builder()
                .id(100L)
                .address(Address.builder()
                        .city("city").street("street").zipcode("zipcode")
                        .build())
                .status(DeliveryStatus.READY)
                .build();
    }

    public List<OrderItem> createOrderItems() {
        return List.of(
                OrderItem.builder().item(Album.builder().build()).count(10).build(),
                OrderItem.builder().item(Book.builder().build()).count(10).build(),
                OrderItem.builder().item(Movie.builder().build()).count(10).build());
    }
}
