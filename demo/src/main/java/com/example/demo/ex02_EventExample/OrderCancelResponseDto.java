package com.example.demo.ex02_EventExample;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCancelResponseDto {

    private String orderUser;
    private final String cancelMessage = "주문이 취소되었습니다.";

    public void printMessage() {
        System.out.println(orderUser + cancelMessage);
    }
}
