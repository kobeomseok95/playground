package com.example.jpashop.util;


import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Order;
import com.example.jpashop.dto.MemberDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

    OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    default MemberDto map(List<Order> orderList) {
        Member member = orderList.stream().map(Order::getMember).findFirst().orElseThrow();

        return MemberDto.builder().name(member.getName())
                .city(member.getAddress().getCity())
                .street(member.getAddress().getStreet())
                .zipcode(member.getAddress().getZipcode())
                .orders(orderList.stream().map(o ->
                        MemberDto.MembersOrderDto.builder()
                                .delivery(
                                        MemberDto.DeliveryDto.builder().city(o.getDelivery().getAddress().getCity())
                                                .street(o.getDelivery().getAddress().getStreet())
                                                .zipcode(o.getDelivery().getAddress().getZipcode())
                                                .deliveryStatus(o.getDelivery().getStatus().name()).build())
                                .orderStatus(o.getStatus().name())
                                .orderItems(o.getOrderItems().stream().map(oi -> MemberDto.OrderItemsDto.builder()
                                        .name(oi.getItem().getName())
                                        .price(oi.getItem().getPrice())
                                        .count(oi.getCount())
                                        .build())
                                        .collect(toList()))
                                .build()
                ).collect(toList()))
                .build();
    }
}
