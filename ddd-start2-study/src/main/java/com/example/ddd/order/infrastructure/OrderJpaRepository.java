package com.example.ddd.order.infrastructure;

import com.example.ddd.order.domain.Order;
import com.example.ddd.order.domain.OrderNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, OrderNo> {
}
