package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class ApiAop {

    @Pointcut("execution(* com.example.aop.ApiController.*(..))")
    public void pointCut() {

    }

    @Pointcut("@annotation(com.example.aop.Timer)")
    public void timerPointcut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] objects = joinPoint.getArgs();

        for (Object param : objects) {
            log.info("들어온 파라미터 값 : {}", param);
        }
        log.info("실행된 Method : {}", method.getName());
    }

    @AfterReturning(value = "pointCut()", returning = "returnValue")
    public void afterRunning(JoinPoint joinPoint, Object returnValue) {
        log.info("실행된 메서드가 리턴한 값 : {}", returnValue);
    }
}
















