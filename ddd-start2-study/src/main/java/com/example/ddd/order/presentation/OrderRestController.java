package com.example.ddd.order.presentation;

import com.example.ddd.order.application.OrderCommandService;
import com.example.ddd.order.application.dto.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderRestController {

    private final OrderCommandService orderCommandService;

    @PostMapping("")
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        orderCommandService.createOrder(orderRequest);
    }
}
