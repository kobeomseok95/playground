package com.example.ddd.order.application.dto.request;

import com.example.ddd.common.domainmodel.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    private String primaryAddress;
    private String secondaryAddress;
    private String zipCode;

    public Address toAddress() {
        return Address.builder()
                .primaryAddress(primaryAddress)
                .secondaryAddress(secondaryAddress)
                .zipCode(zipCode)
                .build();
    }
}
