package com.example.ddd.order.presentation;

import com.example.ddd.order.command.application.OrderCommandService;
import com.example.ddd.order.command.application.dto.request.AddressRequest;
import com.example.ddd.order.command.application.dto.request.OrderRequest;
import com.example.ddd.order.query.OrderData;
import com.example.ddd.order.query.OrderDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderRestController {

    private final OrderCommandService orderCommandService;
    private final OrderDataRepository orderDataQueryRepository;

    @PostMapping("")
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        orderCommandService.createOrder(orderRequest);
    }

    @GetMapping("/{orderId}")
    public OrderData getOrder(@PathVariable Long orderId) {
        return orderDataQueryRepository.findOrderDataById(orderId).orElseThrow();
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
