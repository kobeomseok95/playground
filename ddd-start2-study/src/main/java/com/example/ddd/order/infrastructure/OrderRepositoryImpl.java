package com.example.ddd.order.infrastructure;

import com.example.ddd.order.domain.Order;
import com.example.ddd.order.domain.OrderNo;
import com.example.ddd.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Optional<Order> findById(OrderNo orderNo) {
        return orderJpaRepository.findById(orderNo);
    }

    @Override
    public Order save(Order order) {
        return orderJpaRepository.save(order);
    }
}
