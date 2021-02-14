package com.example.demo.ex02_EventExample.event;

import com.example.demo.ex02_EventExample.Order;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EmailSender implements OrderNotifier {

    @Override
    @org.springframework.core.annotation.Order(2)
    @EventListener(condition = "#orderEvent.sendEmail")
    public void sendNotification(OrderEvent orderEvent) {
        Order order = orderEvent.getOrder();
        System.out.println("Email : " + order.getOrderUser() + "님은 " +
                order.getProduct() + "를 주문하셨습니다. 가격은 " +
                order.getPrice() + "원 입니다.");
    }

    @Override
    @org.springframework.core.annotation.Order(2)
    @EventListener(condition = "#orderCancelEvent.sendEmail")
    public void sendCancelNotification(OrderCancelEvent orderCancelEvent) {
        Order order = orderCancelEvent.getOrder();
        System.out.println("Email : " + order.getOrderUser() + orderCancelEvent.getMessage());
    }
}
