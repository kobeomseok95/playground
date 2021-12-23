package com.example.solid.modules.voucher;

import com.example.solid.modules.voucher.mock.MockVoucher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberVoucherTest {

    @Test
    @DisplayName("of 메서드")
    void of_test() throws Exception {

        // given
        Voucher voucher = MockVoucher.of();
        String phone = "010-1234-1234";

        // when
        MemberVoucher memberVoucher = MemberVoucher.of(phone, voucher);

        // then
        assertAll(
                () -> assertEquals(voucher, memberVoucher.getVoucher()),
                () -> assertNotNull(memberVoucher.getExpiredDateTime()),
                () -> assertEquals(phone, memberVoucher.getPhone())
        );
    }
}