package com.example.demo.ex02_EventExample;

import com.example.demo.ex02_EventExample.event.EmailSender;
import com.example.demo.ex02_EventExample.event.KakaotalkSender;
import com.example.demo.ex02_EventExample.event.OrderCancelEvent;
import com.example.demo.ex02_EventExample.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public OrderResponseDto order(OrderRequestDto request) {
        Order order = doOrder(request);

        if (!order.isSuccess()) {
            throw new IllegalStateException("주문 실패");
        }

        // 메일만
        eventPublisher.publishEvent(new OrderEvent(order, true, false));

        System.out.println("주문이 정상적으로 완료되었습니다.");
        return modelMapper.map(order, OrderResponseDto.class);
    }

    private Order doOrder(OrderRequestDto req) {
        if (req.getOrderUser().isEmpty() || req.getProduct().isEmpty()) {
            return Order.fail(req.getOrderUser(), req.getProduct(), req.getPrice());
        }

        return Order.success(req.getOrderUser(), req.getProduct(), req.getPrice());
    }

    @Transactional
    public OrderCancelResponseDto cancel(OrderCancelRequestDto req) {
        // find 생략
        Order order = Order.cancel(req.getOrderUser(), req.getProduct(), req.getPrice());

        OrderCancelResponseDto response = modelMapper.map(order, OrderCancelResponseDto.class);

        // 카톡만
        eventPublisher.publishEvent(new OrderCancelEvent(order, false, true));

        System.out.println("주문이 정상적으로 취소되었습니다.");
        return response;
    }
}
