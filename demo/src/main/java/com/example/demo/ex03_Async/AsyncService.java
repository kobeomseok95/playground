package com.example.demo.ex03_Async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsyncService {



    /**
     * public 접근, void 혹은 Future 반환형
     * 이 메서드를 호출한(ex) Controller) 쓰레드는
     * Non-blocking으로 동작한다.
     */
    @Async
    public void onAsync() {
        try {
            Thread.sleep(5000);
            log.info("onAsync");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onSync() {
        try {
            Thread.sleep(5000);
            log.info("onSync");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
