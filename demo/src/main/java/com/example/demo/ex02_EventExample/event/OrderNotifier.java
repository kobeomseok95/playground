package com.example.demo.ex02_EventExample.event;

import com.example.demo.ex02_EventExample.Order;

public interface OrderNotifier {

    void sendNotification(OrderEvent orderEvent);

    void sendCancelNotification(OrderCancelEvent orderCancelEvent);
}
