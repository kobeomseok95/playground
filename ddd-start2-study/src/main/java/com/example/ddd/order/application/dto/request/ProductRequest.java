package com.example.ddd.order.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private Long productId;
    private int quantity;
}
