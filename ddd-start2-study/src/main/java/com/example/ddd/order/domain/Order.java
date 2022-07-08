package com.example.ddd.order.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "orders")
public class Order {

    @EmbeddedId
    private OrderNo orderNo;

    @Embedded
    private ShippingInfo shippingInfo;

    @Embedded
    private Orderer orderer;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "order_line",
            joinColumns = @JoinColumn(name = "order_id")
    )
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    public static Order from(Orderer orderer,
                             ShippingInfo shippingInfo,
                             List<OrderLine> orderLines) {
        return Order.builder()
                .orderNo(OrderNo.of())
                .shippingInfo(shippingInfo)
                .orderer(orderer)
                .orderState(OrderState.PREPARING)
                .orderLines(orderLines)
                .build();
    }
}
