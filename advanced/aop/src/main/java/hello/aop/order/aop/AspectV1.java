package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect // 컴포넌트 스캔 대상이 아님에 유의하기
public class AspectV1 {

    @Around("execution(* hello.aop.order..*(..))")
    public Object doLog(ProceedingJoinPoint pjp) throws Throwable{
        log.info("[log] {}", pjp.getSignature());
        return pjp.proceed();
    }
}
