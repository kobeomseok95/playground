package com.example.demo.user.application.usecase;

import com.example.demo.user.application.port.in.UserCreateCommand;
import com.example.demo.common.holder.code.CertificationCodeHolder;
import com.example.demo.user.application.port.out.SaveUserAdapter;
import com.example.demo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserUsecase {
    private final SaveUserAdapter saveUserAdapter;
    private final CertificationCodeHolder certificationCodeHolder;

    @Transactional
    public User createUser(UserCreateCommand command) {
        User user = User.of(command, certificationCodeHolder);
        return saveUserAdapter.save(user);
    }
}
