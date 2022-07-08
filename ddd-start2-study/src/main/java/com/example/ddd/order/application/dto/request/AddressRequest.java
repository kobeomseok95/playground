package com.example.ddd.order.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    private String primaryAddress;
    private String secondaryAddress;
    private String zipCode;
}
