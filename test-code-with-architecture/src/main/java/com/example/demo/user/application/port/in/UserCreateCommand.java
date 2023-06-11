package com.example.demo.user.application.port.in;

import lombok.Builder;
import lombok.Value;

@Value
public class UserCreateCommand {
    String email;
    String nickname;
    String address;

    @Builder
    public UserCreateCommand(
        String email,
        String nickname,
        String address
    ) {
        this.email = email;
        this.nickname = nickname;
        this.address = address;
    }
}
