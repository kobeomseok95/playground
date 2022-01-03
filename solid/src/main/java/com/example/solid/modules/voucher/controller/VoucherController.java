package com.example.solid.modules.voucher.controller;

import com.example.solid.modules.voucher.VoucherService;
import com.example.solid.modules.voucher.controller.dto.BuyVoucherRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/voucher")
public class VoucherController {

    private final VoucherService voucherService;

    @PostMapping("")
    public ResponseEntity<Void> buyVoucher(@RequestBody BuyVoucherRequest buyVoucherRequest) {
        voucherService.buyVoucher(buyVoucherRequest);
        return ResponseEntity.ok().build();
    }
}
