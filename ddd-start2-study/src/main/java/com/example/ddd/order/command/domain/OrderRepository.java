package com.example.ddd.order.command.domain;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(Long orderId);

    Order save(Order order);

    Optional<Order> findWithPessimisticLockById(Long orderId);

    Optional<Order> findWithOptimisticLockById(Long orderId);

    List<Order> findByOrdererId(Long ordererId);
}
