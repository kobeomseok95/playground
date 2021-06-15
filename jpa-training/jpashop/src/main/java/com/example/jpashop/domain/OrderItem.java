package com.example.jpashop.domain;

import com.example.jpashop.domain.item.Item;
import com.example.jpashop.dto.OrderDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@TableGenerator(
        name = "ORDER_ITEM_GENERATOR",
        table = "ORDER_ITEM_SEQUENCE",
        pkColumnName = "SEQUENCE_NUMBER",
        valueColumnName = "next_val",
        allocationSize = 1000
)
public class OrderItem extends BaseEntity{

    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "ORDER_ITEM_GENERATOR"
    )
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int count;

    // TODO : 추후 Stream으로 리팩토링
    public static List<OrderItem> createOrderItem(List<OrderDto.OrderItemDto> orderItemDto, List<Item> items) {

        List<OrderDto.OrderItemDto> sortedByItemIdOrderItemDto = orderItemDto.stream()
                .sorted(Comparator.comparing(oi -> Long.parseLong(oi.getItemId()))).collect(toList());

        List<OrderItem> orderItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            items.get(i).removeStock(sortedByItemIdOrderItemDto.get(i).getCount());
            orderItems.add(OrderItem.builder()
                    .item(items.get(i)).count(sortedByItemIdOrderItemDto.get(i).getCount()).build());
        }

        return orderItems;
    }

    public void addOrder(Order order) {
        this.order = order;
    }
}
