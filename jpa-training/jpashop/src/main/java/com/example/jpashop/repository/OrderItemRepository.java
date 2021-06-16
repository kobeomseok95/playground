package com.example.jpashop.repository;

import com.example.jpashop.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

//    @Query("select oi from OrderItem oi " +
//            "join fetch oi.item i " +
//            "join fetch oi.order o " +
//            "where o.id in :orderIds " +
//            "order by o.id")
//    List<OrderItem> findByOrderIdsFetch(@Param("orderIds") List<Long> orderIds);
}
