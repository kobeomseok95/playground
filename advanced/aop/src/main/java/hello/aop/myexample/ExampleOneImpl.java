package hello.aop.myexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExampleOneImpl implements Example {

    @Override
    public void example() {
        log.info("example one");
    }
}
