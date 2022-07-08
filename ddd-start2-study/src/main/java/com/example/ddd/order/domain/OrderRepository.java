package com.example.ddd.order.domain;

import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(OrderNo orderNo);

    Order save(Order order);
}
