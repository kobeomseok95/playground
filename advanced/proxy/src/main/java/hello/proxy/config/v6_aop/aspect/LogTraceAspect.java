package hello.proxy.config.v6_aop.aspect;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class LogTraceAspect {

    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    // 하나의 메서드가 어드바이저가 된다.
    @Around("execution(* hello.proxy.app..*(..))")  // 포인트컷
    public Object execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // 어드바이스
        TraceStatus status = null;
        try {
            String message = proceedingJoinPoint.getSignature().toShortString();
            status = logTrace.begin(message);
            Object result = proceedingJoinPoint.proceed();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
