package com.example.jpashop.domain;

import com.example.jpashop.domain.item.Item;
import com.example.jpashop.dto.OrderDto;
import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int count;

    public static OrderItem createOrderItem(Item item, OrderDto.OrderItemDto orderItemDto) {

        item.removeStock(orderItemDto.getCount());
        return OrderItem.builder().item(item).count(orderItemDto.getCount()).build();
    }

    public void addOrder(Order order) {
        this.order = order;
    }
}
