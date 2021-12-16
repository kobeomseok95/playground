package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV3 {

    @Pointcut("execution(* hello.aop.order..*(..))")
    private void allOrder() {}

    @Pointcut("execution(* *..*Service.*(..))")
    private void allService() {}

    @Around("allOrder()")
    public Object doLog(ProceedingJoinPoint pjp) throws Throwable{
        log.info("[log] {}", pjp.getSignature());
        return pjp.proceed();
    }

    @Around("allOrder() && allService()")
    public Object doTransaction(ProceedingJoinPoint pjp) throws Throwable {
        try {
            log.info("[트랜잭션 시작] {}", pjp.getSignature());
            Object result = pjp.proceed();
            log.info("[트랜잭션 커밋] {}", pjp.getSignature());
            return result;
        } catch (Exception e) {
            log.info("[트랜잭션 롤백] {}", pjp.getSignature());
            throw e;
        } finally {
            log.info("[리소스 릴리즈] {}", pjp.getSignature());
        }
    }
}
