package com.example.solid.modules.voucher.controller.dto;

public class MockBuyVoucherRequest {

    public static BuyVoucherRequest of() {
        return BuyVoucherRequest.builder()
                .voucherId(1L)
                .phone("010-1234-1234")
                .build();
    }
}
