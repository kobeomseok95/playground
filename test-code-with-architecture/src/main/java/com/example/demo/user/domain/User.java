package com.example.demo.user.domain;

import com.example.demo.user.application.port.in.UserCreateCommand;
import com.example.demo.common.holder.code.CertificationCodeHolder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@Builder
public final class User {
    private final Long id;
    private final String email;
    private final String nickname;
    private final String address;
    private final String certificationCode;
    private final UserStatus userStatus;
    private final LocalDateTime lastLoginAt;

    public static User of(
            UserCreateCommand command,
            CertificationCodeHolder holder
    ) {
        return User.builder()
                .email(command.getEmail())
                .nickname(command.getNickname())
                .address(command.getAddress())
                .certificationCode(holder.generate())
                .userStatus(UserStatus.PENDING)
                .build();
    }
}
