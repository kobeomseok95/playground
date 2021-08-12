package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Performance {

    @Around("execution(* com.example.aop.board.BoardService.getBoards(..))")
    public Object calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("수행 시간 : "+ (end - start)) ;
        } catch (Throwable throwable) {
            System.out.println("exception! ");
        }
        return result;
    }

    @AfterReturning("execution(* com.example.aop.user.UserService.getUsers(..))")
    public void calculatePerformanceTime() {
        System.out.println("========================실행 완료!========================");
    }
}
