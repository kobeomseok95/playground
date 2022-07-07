package com.example.ddd.order.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(of = "number")
@Builder
public class OrderNo implements Serializable {

    @Column(name = "order_id")
    private String number;

    protected static OrderNo of() {
        return OrderNo.builder()
                .number(UUID.randomUUID().toString())
                .build();
    }
}
