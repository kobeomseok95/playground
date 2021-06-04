package com.example.jpashop.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
public class OrderDto {

    private String memberId;
    private AddressDto addressDto;
    private List<OrderItemDto> orderItemDtos;

    @Getter @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
    public static class AddressDto {

        private String city;
        private String street;
        private String zipcode;
    }

    @Getter @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
    public static class OrderItemDto {

        private String itemId;
        private int count;
    }
}
