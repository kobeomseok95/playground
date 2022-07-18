package com.example.ddd.order.command.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Receiver {

    @Column(name = "receiver_name", nullable = false)
    private String name;

    @Column(name = "receiver_phone", nullable = false)
    private String phone;
}
