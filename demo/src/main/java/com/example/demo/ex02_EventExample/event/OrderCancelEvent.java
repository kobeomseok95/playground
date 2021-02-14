package com.example.demo.ex02_EventExample.event;

import com.example.demo.ex02_EventExample.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderCancelEvent {

    private final Order order;
    private final String message = "주문이 정상 취소되었습니다.";
    private final boolean sendEmail;
    private final boolean sendKakaoTalk;
}
