package com.example.jpashop.service;

import com.example.jpashop.dto.OrderDto;

public interface OrderService {

    void createOrder(OrderDto orderDto);

    void cancelOrder(String orderId);
}
