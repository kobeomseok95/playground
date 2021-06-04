package com.example.jpashop.repository;

import com.example.jpashop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select distinct o from Order o join fetch o.orderItems oi join fetch oi.item i" +
            " join fetch o.delivery d")
    Optional<Order> findIdFetch(Long orderId);
}
