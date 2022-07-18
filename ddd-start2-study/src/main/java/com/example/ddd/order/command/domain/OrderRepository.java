package com.example.ddd.order.command.domain;

import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(Long orderId);

    Order save(Order order);

    Optional<Order> findByIdForUpdate(Long orderId);
}
