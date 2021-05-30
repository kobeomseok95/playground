package com.example.jpashop.dto;

import lombok.*;

public class MemberDto {

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class JoinRequest {

        private String name;
        private String city;
        private String street;
        private String zipcode;
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class JoinResponse {

        private String name;
        private String city;
        private String street;
        private String zipcode;
    }
}
