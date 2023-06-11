package com.example.demo.user.application.usecase;

import com.example.demo.common.holder.TestUuidHolder;
import com.example.demo.user.adapter.port.out.persistence.FakeSaveUserAdapter;
import com.example.demo.user.application.port.in.UserCreateCommand;
import com.example.demo.user.application.port.in.UserCreateCommandFixture;
import com.example.demo.common.holder.code.CertificationCodeHolder;
import com.example.demo.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UserUsecaseTest {
    private final FakeSaveUserAdapter saveUserAdapter = new FakeSaveUserAdapter();
    private final CertificationCodeHolder certificationCodeHolder = new TestUuidHolder(UUID.randomUUID());
    private final UserUsecase userUsecase = new UserUsecase(
            saveUserAdapter,
            certificationCodeHolder
    );

    @AfterEach
    void tearDown() {
        saveUserAdapter.clear();
    }

    @Test
    void 유저_생성() {
        UserCreateCommand command = UserCreateCommandFixture.stub();

        User createdUser = userUsecase.createUser(command);

        Assertions.assertNotNull(createdUser.getId());
        Assertions.assertEquals(createdUser.getCertificationCode(), certificationCodeHolder.generate());
    }
}
