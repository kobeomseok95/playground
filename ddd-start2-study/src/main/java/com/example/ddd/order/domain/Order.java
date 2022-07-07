package com.example.ddd.order.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "purchase_order")
public class Order {

    @EmbeddedId
    private OrderNo orderNo;

    @Embedded
    private ShippingInfo shippingInfo;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "order_line",
            joinColumns = @JoinColumn(name = "order_id")
    )
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;
}
