package hello.aop.myexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InternalExample {

    public void internal() {
        log.info("internal method");
    }
}
