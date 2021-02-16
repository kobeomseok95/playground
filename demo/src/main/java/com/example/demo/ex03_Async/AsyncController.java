package com.example.demo.ex03_Async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping("/async")
    public String goAsync() {
        asyncService.onAsync();
        String ret = "비동기 호출, 위치 = Controller";
        log.info(ret);
        log.info("========================================================================");
        return ret;
    }

    @GetMapping("/sync")
    public String goSync() {
        asyncService.onSync();
        String ret = "동기 호출, 위치 = Controller";
        log.info(ret);
        log.info("========================================================================");
        return ret;
    }
}
