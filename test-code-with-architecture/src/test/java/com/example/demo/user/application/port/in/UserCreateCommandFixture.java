package com.example.demo.user.application.port.in;

public class UserCreateCommandFixture {
    public static UserCreateCommand stub() {
        return UserCreateCommand.builder()
                .email("test@test.com")
                .address("서울 광진구")
                .nickname("고범석짱짱짱")
                .build();
    }
}
