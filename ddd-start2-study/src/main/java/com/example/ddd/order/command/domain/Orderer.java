package com.example.ddd.order.command.domain;

import com.example.ddd.member.query.MemberData;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Orderer {

    @Column(name = "orderer_id")
    private Long ordererId;

    @Column(name = "orderer_name")
    private String ordererName;

    public static Orderer of(MemberData ordererData) {
        return Orderer.builder()
                .ordererId(ordererData.getId())
                .ordererName(ordererData.getMemberName())
                .build();
    }
}
