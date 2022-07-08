package com.example.ddd.order.application.dto.request;

import com.example.ddd.common.domainmodel.Address;
import com.example.ddd.order.domain.Receiver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingRequest {

    private AddressRequest address;
    private ReceiverRequest receiver;
    private String shippingMessage;

    public Address toAddress() {
        return Address.builder()
                .primaryAddress(address.getPrimaryAddress())
                .secondaryAddress(address.getSecondaryAddress())
                .zipCode(address.getZipCode())
                .build();
    }

    public Receiver toReceiver() {
        return Receiver.builder()
                .name(receiver.getReceiverName())
                .phone(receiver.getReceiverPhone())
                .build();

    }
}
