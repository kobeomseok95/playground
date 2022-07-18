package com.example.ddd.order.presentation;

import com.example.ddd.order.application.OrderCommandService;
import com.example.ddd.order.application.dto.request.AddressRequest;
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

    @PatchMapping("/{orderId}/address")
    public void changeOrderAddress(
            @PathVariable Long orderId,
            @RequestBody AddressRequest addressRequest
    ) {
        orderCommandService.changeOrderAddress(orderId, addressRequest);
    }

    @PatchMapping("/{orderId}/{orderState}")
    public void changeOrderState(
            @PathVariable Long orderId,
            @PathVariable String orderState
    ) {
        orderCommandService.changeOrderState(orderId, orderState);
    }
}
