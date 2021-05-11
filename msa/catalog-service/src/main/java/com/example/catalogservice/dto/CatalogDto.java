package com.example.catalogservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CatalogDto implements Serializable {

    private String productId;
    private int quantity;
    private int unitPrice;
    private int totalPrice;

    private String orderId;
    private String userId;
}
