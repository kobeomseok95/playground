package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 *      포인트컷의 재사용 강화
 */
@Slf4j
@Aspect
public class AspectV2 {

    @Pointcut("execution(* hello.aop.order..*(..))")
    private void allOrder() {}  // Pointcut Signature 항상 리턴 타입은 void

    @Around("allOrder()")
    public Object doLog(ProceedingJoinPoint pjp) throws Throwable{
        log.info("[log] {}", pjp.getSignature());
        return pjp.proceed();
    }
}
