package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterIsEvenAspect {

    @Pointcut("execution (* com.example.aop.check.CheckService.*(..))")
    public void parameterIsEven() { }

    @Pointcut("execution(* com.example.aop.check.CheckService.checkEven(..))")
    public void checkEven() { }

    @Pointcut("execution(* com.example.aop.check.CheckService.checkOdd(..))")
    public void checkOdd() { }

    @Before("checkEven() && parameterIsEven()")
    public void checkEvenAspect(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        int number = (int) args[0];
        if (number % 2 == 0) {
            System.out.println("짝수! 검증 완료");
        } else {
            throw new RuntimeException("검증 실패");
        }
    }

    @Before("checkOdd() && parameterIsEven()")
    public void checkOddAspect(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        int number = (int) args[0];
        if (number % 2 != 0) {
            System.out.println("홀수! 검증 완료");
        } else {
            throw new RuntimeException("검증 실패");
        }
    }
}
