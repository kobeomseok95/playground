package com.example.solid.modules.voucher;

import com.example.solid.modules.voucher.controller.dto.BuyVoucherRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class VoucherService {

    private final VoucherRepository voucherRepository;
    private final MemberVoucherRepository memberVoucherRepository;

    public void buyVoucher(BuyVoucherRequest buyVoucherRequest) {
        Voucher voucher = voucherRepository
                .findById(buyVoucherRequest.getVoucherId())
                .orElseThrow(IllegalArgumentException::new);
        MemberVoucher memberVoucher = MemberVoucher.of(buyVoucherRequest.getPhone(), voucher);
        memberVoucherRepository.save(memberVoucher);
    }
}
