package com.example.ddd.order.command.domain;

public enum OrderState {

    PAYMENT_WAITING,
    PREPARING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED,
}
