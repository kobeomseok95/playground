package com.example.orderservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {

    private String productId;
    private int quantity;
    private int unitPrice;
    private int totalPrice;

    private LocalDateTime createdAt;
    private String orderId;
}
