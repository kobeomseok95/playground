package com.example.ddd.order.command.domain;

import com.example.ddd.member.command.domain.MemberInfoChangedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrdererChangeHandler {

    private final OrderRepository orderRepository;

    // TODO: 2022/07/29 kobeomseok95 트랜잭션이 없어 수정되지 않는 현상 발생, 어떻게 해결하지?
    @Async
    @EventListener(MemberInfoChangedEvent.class)
    public void changeOrderer(MemberInfoChangedEvent event) {
        List<Order> changedOrdererOrders = orderRepository.findByOrdererId(event.getMemberId());
        changedOrdererOrders.forEach(order -> order.changeOrderer(event.getMemberName()));
    }
}
