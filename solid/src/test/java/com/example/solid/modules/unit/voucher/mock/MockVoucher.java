package com.example.solid.modules.unit.voucher.mock;

import com.example.solid.modules.unit.voucher.domain.Voucher;

public class MockVoucher {

    public static Voucher of() {
        return Voucher.builder()
                .id(1L)
                .passName("[당일권] 2시간")
                .time(2)
                .price(3000)
                .build();
    }
}
