package com.example.solid.modules.voucher;

import com.example.solid.modules.voucher.controller.dto.BuyVoucherRequest;
import com.example.solid.modules.voucher.controller.dto.MockBuyVoucherRequest;
import com.example.solid.modules.voucher.mock.MockVoucher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VoucherServiceTest {

    @Mock VoucherRepository voucherRepository;
    @Mock MemberVoucherRepository memberVoucherRepository;
    @InjectMocks VoucherService voucherService;

    @Test
    @DisplayName("이용권 구매 / 성공")
    void buy_voucher() throws Exception {

        // given
        BuyVoucherRequest request = MockBuyVoucherRequest.of();
        when(voucherRepository.findById(request.getVoucherId()))
                .thenReturn(Optional.of(MockVoucher.of()));

        // when
        voucherService.buyVoucher(request);

        // then
        assertAll(
                () -> verify(memberVoucherRepository).save(any()),
                () -> verify(voucherRepository).findById(request.getVoucherId())
        );
    }

    @Test
    @DisplayName("이용권 구매 / 실패, 찾는 이용권이 없을 경우")
    void buy_voucher_when_not_found_voucher_should_throw_exception() throws Exception {

        // given
        when(voucherRepository.findById(any())).thenThrow(IllegalStateException.class);

        // when, then
        assertThrows(IllegalStateException.class,
                () -> voucherService.buyVoucher(MockBuyVoucherRequest.of()));
    }
}