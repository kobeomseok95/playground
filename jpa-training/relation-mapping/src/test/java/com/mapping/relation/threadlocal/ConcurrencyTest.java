package com.mapping.relation.threadlocal;

import com.mapping.relation.threadlocal.code.CompositeService;
import com.mapping.relation.threadlocal.code.FieldService;
import com.mapping.relation.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ConcurrencyTest {

    private FieldService fieldService = new FieldService();
    private ThreadLocalService threadLocalService = new ThreadLocalService();
    private CompositeService compositeService = new CompositeService();

    @Test
    void field() throws Exception {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000);
//        sleep(100);
        threadB.start();
        // todo 여기까지만 작성하고 끝내면 threadB를 호출하고 테스트가 끝나버린다.
        sleep(3000);
        log.info("main exit");
    }


    private void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void threadLocal() throws Exception {
        log.info("main start");
        Runnable userA = () -> {
            threadLocalService.logic("userA");
        };
        Runnable userB = () -> {
            threadLocalService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000);
        sleep(100);
        threadB.start();
        // todo 여기까지만 작성하고 끝내면 threadB를 호출하고 테스트가 끝나버린다.
        sleep(3000);
        log.info("main exit");
    }

    @Test
    void composite() throws Exception {
        log.info("main start");
        Runnable userA = () -> {
            compositeService.logic("userA");
        };
        Runnable userB = () -> {
            compositeService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000);
        sleep(100);
        threadB.start();
        sleep(3000);
        log.info("main exit");
    }
}
