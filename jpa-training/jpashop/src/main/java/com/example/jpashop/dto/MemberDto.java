package com.example.jpashop.dto;

import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Order;
import com.example.jpashop.domain.OrderItem;
import lombok.*;

import java.util.List;

import static java.util.stream.Collectors.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberDto {

    private String name;
    private String city;
    private String street;
    private String zipcode;
    private List<MembersOrderDto> orders;

    public static MemberDto mapMemberDto(Member member, List<Order> orderList) {

        return MemberDto.builder().name(member.getName())
                .city(member.getAddress().getCity())
                .street(member.getAddress().getStreet())
                .zipcode(member.getAddress().getZipcode())
                .orders(orderList.stream().map(o ->
                        MembersOrderDto.builder()
                                .delivery(
                                        DeliveryDto.builder().city(o.getDelivery().getAddress().getCity())
                                                .street(o.getDelivery().getAddress().getStreet())
                                                .zipcode(o.getDelivery().getAddress().getZipcode())
                                                .deliveryStatus(o.getDelivery().getStatus().name()).build())
                                .orderStatus(o.getStatus().name())
                                .orderItems(o.getOrderItems().stream().map(oi -> OrderItemsDto.builder()
                                        .name(oi.getItem().getName())
                                        .price(oi.getItem().getPrice())
                                        .count(oi.getCount())
                                        .build())
                                        .collect(toList()))
                                .build()
                ).collect(toList()))
                .build();
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class MembersOrderDto {

        private DeliveryDto delivery;
        private String orderStatus;
        private List<OrderItemsDto> orderItems;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class OrderItemsDto {

        private String name;
        private int price;
        private int count;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class DeliveryDto {

        private String city;
        private String street;
        private String zipcode;
        private String deliveryStatus;
    }
}
