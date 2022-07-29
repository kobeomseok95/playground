package com.example.ddd.order.infrastructure;

import com.example.ddd.order.command.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({
            @QueryHint(name = "javax.persistence.lock.timeout", value = "5000")
    })
    @Query("select o from Order o where o.id = :id")
    Optional<Order> findWithPessimisticLockById(@Param("id") Long orderId);

    @Lock(LockModeType.OPTIMISTIC)
    @Query("select o from Order o where o.id = :id")
    Optional<Order> findWithOptimisticLockById(@Param("id") Long orderId);

    @Query("select o from Order o where o.orderer.ordererId = :ordererId")
    List<Order> findByOrdererId(@Param("ordererId") Long ordererId);
}
