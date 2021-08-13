package com.example.aop.aspect;

import com.example.aop.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class GetUserAspect {

    private final UserRepository userRepository;

    @Pointcut("@annotation(com.example.aop.aspect.GetUser)")
    public void getUser(){}

    @Around("execution(* *(.., @GetUser (*), ..))")
    public Object getUser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        Long userId = (Long) args[0];
        args[1] = userRepository.findById(userId);
        return proceedingJoinPoint.proceed(args);
    }
}
