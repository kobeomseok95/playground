package hello.aop.myexample;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyExampleAspect {

    @Before("execution(* hello.aop.myexample..*.*(..))")
    public void before() {
        log.info("before AOP");
    }
}
