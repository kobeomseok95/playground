package com.example.jpashop.repository;

import com.example.jpashop.domain.Order;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderQueryRepository {

    Optional<Order> findIdFetch(Long orderId);

    List<Order> findByMemberIdFetch(Long memberId);
}
