package com.example.jpashop.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<OrderItem> orderItems = new ArrayList<>();

    // cascade : Order가 삭제되면 Delivery 정보도 같이 삭제됨.
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public static Order createOrder(Member member, Delivery delivery, List<OrderItem> orderItems) {

        Order order = Order.builder()
                .member(member)
                .orderItems(orderItems)
                .delivery(delivery)
                .status(OrderStatus.ORDER)
                .build();

        orderItems.forEach(o -> o.addOrder(order));

        return order;
    }

    public void cancelOrder() {
        this.status = OrderStatus.CANCEL;
        this.getDelivery().cancelDelivery();
        this.getOrderItems().forEach(oi -> {
            oi.getItem().addStock(oi.getCount());
        });
    }
}
