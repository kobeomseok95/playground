package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA() throws Exception {
        AInterface target = new AImpl();
        TimeInvocationHandler invocationHandler = new TimeInvocationHandler(target);
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(),
                new Class[]{AInterface.class},
                invocationHandler);
        int result = proxy.callInteger();
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
        log.info("result = {}", result);
    }

    @Test
    void dynamicB() throws Exception {
        BInterface target = new BImpl();
        TimeInvocationHandler invocationHandler = new TimeInvocationHandler(target);
        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(),
                new Class[]{BInterface.class},
                invocationHandler);
        String result = proxy.call();
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
        log.info("result = {}", result);
    }

    @Test
    void integrationAB() throws Exception {
        AInterface a = new AImpl();
        TimeInvocationHandler aHandler = new TimeInvocationHandler(a);
        AInterface proxyA = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(),
                new Class[] {AInterface.class},
                aHandler);
        log.info("================== {}", proxyA.callInteger());

        BInterface b = new BImpl();
        TimeInvocationHandler bHandler = new TimeInvocationHandler(b);
        BInterface proxyB = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(),
                new Class[] {BInterface.class},
                bHandler);
        log.info("================== {}", proxyB.call());
    }

    @Test
    void should_equal_type_A() throws Exception {
        AInterface a = new AImpl();
        TimeInvocationHandler aHandler = new TimeInvocationHandler(a);
        AInterface proxyA = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(),
                        new Class[] {AInterface.class},
                        aHandler);
        log.info("================== {}", proxyA.callInteger());
    }

    @Test
    void make_my_proxy() throws Exception {
        CalculateInterface plusInterface = Integer::sum;
        PrintInvocationHandler printInvocationHandler = new PrintInvocationHandler(plusInterface);
        CalculateInterface calc = (CalculateInterface) Proxy.newProxyInstance(CalculateInterface.class.getClassLoader(),
                new Class[]{CalculateInterface.class},
                printInvocationHandler);
        calc.calculate(1, 2);
    }
}
