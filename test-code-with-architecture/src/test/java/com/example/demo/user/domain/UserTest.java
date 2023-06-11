package com.example.demo.user.domain;

import com.example.demo.common.holder.TestUuidHolder;
import com.example.demo.user.application.port.in.UserCreateCommand;
import com.example.demo.user.application.port.in.UserCreateCommandFixture;
import com.example.demo.common.holder.code.CertificationCodeHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UserTest {

    private final CertificationCodeHolder holder = new TestUuidHolder(UUID.randomUUID());

    @Test
    void 유저_생성() {
        UserCreateCommand command = UserCreateCommandFixture.stub();

        User user = User.of(command, holder);

        Assertions.assertEquals(user.getEmail(), command.getEmail());
        Assertions.assertEquals(user.getNickname(), command.getNickname());
        Assertions.assertEquals(user.getAddress(), command.getAddress());
        Assertions.assertEquals(user.getUserStatus(), UserStatus.PENDING);
        Assertions.assertEquals(user.getCertificationCode(), holder.generate());
    }
}
