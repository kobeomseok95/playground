package com.example.ddd.order.domain;

import com.example.ddd.common.domainmodel.Address;
import lombok.*;

import javax.persistence.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ShippingInfo {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zip_code")),
            @AttributeOverride(name = "primaryAddress", column = @Column(name = "shipping_primary_address")),
            @AttributeOverride(name = "secondaryAddress", column = @Column(name = "shipping_secondary_address"))
    })
    private Address address;

    @Column(name = "shipping_message")
    private String shippingMessage;

    @Embedded
    private Receiver receiver;

    public void changeAddress(Address address) {
        this.address = address;
    }
}
