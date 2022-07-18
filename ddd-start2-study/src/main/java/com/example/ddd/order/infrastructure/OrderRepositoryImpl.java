package com.example.ddd.order.infrastructure;

import com.example.ddd.order.command.domain.Order;
import com.example.ddd.order.command.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Optional<Order> findById(Long orderId) {
        return orderJpaRepository.findById(orderId);
    }

    @Override
    public Order save(Order order) {
        return orderJpaRepository.save(order);
    }

    @Override
    public Optional<Order> findByIdForUpdate(Long orderId) {
        return orderJpaRepository.findByIdForUpdate(orderId);
    }
}
