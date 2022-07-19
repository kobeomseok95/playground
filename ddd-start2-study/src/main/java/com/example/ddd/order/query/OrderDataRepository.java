package com.example.ddd.order.query;

import com.example.ddd.order.command.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderDataRepository extends JpaRepository<Order, Long> {

    @Query(
            "select new com.example.ddd.order.query.OrderData(o.id, o.version, o.orderState, o.orderer.ordererName, o.shippingInfo.address.primaryAddress, o.shippingInfo.address.secondaryAddress, o.shippingInfo.address.zipCode) " +
            "from Order o " +
            "where o.id = :id"
    )
    Optional<OrderData> findOrderDataById(@Param("id") Long orderId);
}
