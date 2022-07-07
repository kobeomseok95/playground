package com.example.ddd.order.domain;

import com.example.ddd.common.domainmodel.Address;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

}
