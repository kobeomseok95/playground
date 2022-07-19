package com.example.ddd.order.query;

import com.example.ddd.order.command.domain.OrderState;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderData {

    private Long id;
    private Long version;
    private OrderState orderState;
    private String ordererName;
    private String firstAddress;
    private String secondAddress;
    private String zipCode;
}
