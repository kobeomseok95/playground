package hello.aop.myexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
//@SpringBootTest
@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"}) //JDK 동적 프록시
class ExampleOneImplTest {

    @Autowired
    List<Example> examples;
//    @Autowired
//    ExampleOneImpl exampleOneImpl;

    @Test
    void examples() {
        for (Example example : examples) {
            log.info("example class = {}", example.getClass());
            example.example();
        }
    }

//    @Test
//    void exampleOne() {
//        log.info("example class = {}", exampleOneImpl.getClass());
//        exampleOneImpl.example();
//    }
}