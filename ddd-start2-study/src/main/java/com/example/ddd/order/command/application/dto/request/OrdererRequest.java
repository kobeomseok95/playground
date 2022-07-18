package com.example.ddd.order.command.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdererRequest {

    private Long ordererId;
    private String ordererName;
}
