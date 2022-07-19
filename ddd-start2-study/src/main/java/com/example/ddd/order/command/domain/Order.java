package com.example.ddd.order.command.domain;

import com.example.ddd.common.domainmodel.Address;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Version
    private Long version;

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
                .shippingInfo(shippingInfo)
                .orderer(orderer)
                .orderState(OrderState.PREPARING)
                .orderLines(orderLines)
                .build();
    }

    private void checkOrderStatePreparing() {
        if (orderState != OrderState.PREPARING) {
            throw new IllegalStateException("준비 상태에서만 변경 가능합니다.");
        }
    }

    public void changeOrderAddress(Address address) {
        checkOrderStatePreparing();
        shippingInfo.changeAddress(address);
    }

    public void changeOrderState(OrderState state) {
        this.orderState = state;
    }
}
