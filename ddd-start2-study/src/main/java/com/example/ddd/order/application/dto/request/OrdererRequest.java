package com.example.ddd.order.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdererRequest {

    private Long ordererId;
    private String ordererName;
}
