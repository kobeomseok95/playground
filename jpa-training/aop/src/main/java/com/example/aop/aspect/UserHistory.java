package com.example.aop.aspect;

import com.example.aop.history.History;
import com.example.aop.history.HistoryRepository;
import com.example.aop.user.User;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class UserHistory {

    private final HistoryRepository historyRepository;

    @Pointcut("execution(* com.example.aop.user.UserService.update(*)) && args(user)")
    public void updateUser(User user) {}

    @AfterReturning("updateUser(user)")
    public void saveHistory(User user) {
        historyRepository.save(History.builder()
                .userIdx(user.getId())
                .build());
    }
}
