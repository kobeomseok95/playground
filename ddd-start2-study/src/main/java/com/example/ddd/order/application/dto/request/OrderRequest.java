package com.example.ddd.order.application.dto.request;

import com.example.ddd.order.domain.ShippingInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {

    private ShippingRequest shipping;
    private OrdererRequest orderer;
    private List<ProductRequest> products;

    public ShippingInfo toShippingInfo() {
        return ShippingInfo.builder()
                .address(shipping.toAddress())
                .receiver(shipping.toReceiver())
                .shippingMessage(shipping.getShippingMessage())
                .build();
    }
}
