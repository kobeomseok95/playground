package com.example.demo.ex02_EventExample;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCancelRequestDto {

    private String orderUser;
    private String product;
    private int price;
}
