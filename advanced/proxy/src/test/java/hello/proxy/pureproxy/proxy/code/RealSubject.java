package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject{

    @Override
    public String operation() throws InterruptedException {
        log.info("실제 객체 호출");
        sleep(1000);
        return "data";
    }

    private void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
