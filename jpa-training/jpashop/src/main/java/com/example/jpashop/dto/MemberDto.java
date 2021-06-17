package com.example.jpashop.dto;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberDto {

    private String name;
    private String city;
    private String street;
    private String zipcode;
    private List<MembersOrderDto> orders;

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
