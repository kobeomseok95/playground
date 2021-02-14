package com.example.demo.ex02_EventExample.event;

import com.example.demo.ex02_EventExample.Order;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class KakaotalkSender implements OrderNotifier {

    @Override
    @org.springframework.core.annotation.Order(1)
    @EventListener(condition = "#orderEvent.sendKakaoTalk")
    public void sendNotification(OrderEvent orderEvent) {
        Order order = orderEvent.getOrder();
        System.out.println("Kakaotalk : " + order.getOrderUser() + "님은 " +
                order.getProduct() + "를 주문하셨습니다. 가격은 " +
                order.getPrice() + "원 입니다.");
    }

    @Override
    @org.springframework.core.annotation.Order(1)
    @EventListener(condition = "#orderCancelEvent.sendKakaoTalk")
    public void sendCancelNotification(OrderCancelEvent orderCancelEvent) {
        Order order = orderCancelEvent.getOrder();
        System.out.println("Kakaotalk : " + order.getOrderUser() + orderCancelEvent.getMessage());
    }
}
