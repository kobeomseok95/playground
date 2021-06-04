package com.example.jpashop.controller;

import com.example.jpashop.dto.OrderDto;
import com.example.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/")
    public String createRequest(@RequestBody OrderDto orderDto) {

        orderService.createOrder(orderDto);
        return "주문 완료";
    }

    @PostMapping("/{orderId}")
    public String createRequest(@PathVariable("orderId") String orderId) {

        orderService.cancelOrder(orderId);
        return "주문 취소 완료";
    }
}
