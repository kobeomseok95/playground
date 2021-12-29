package com.example.solid.modules.unit.voucher.mock;

import com.example.solid.modules.unit.voucher.domain.MemberVoucher;

import java.time.LocalDateTime;

public class MockMemberVoucher {

    public static MemberVoucher of() {
        return MemberVoucher.builder()
                .id(1L)
                .expiredDateTime(LocalDateTime.now().plusHours(2))
                .voucher(MockVoucher.of())
                .phone("010-1234-1234")
                .build();
    }
}
