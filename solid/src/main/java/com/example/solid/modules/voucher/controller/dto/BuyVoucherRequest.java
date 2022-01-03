package com.example.solid.modules.voucher.controller.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyVoucherRequest {

    private String phone;
    private Long voucherId;
}
