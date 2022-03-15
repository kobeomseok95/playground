package com.mapping.relation.threadlocal.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CompositeService {

    private ThreadLocal<String> nameThreadLocalStore = new ThreadLocal<>();
    private String commonNameStore;

    public void logic(String name) {
        log.info("=================== 저장 전, parameter = {}, commonName = {}, threadLocalName = {}", name, commonNameStore, nameThreadLocalStore.get());
        commonNameStore = name;
        nameThreadLocalStore.set(name);
        sleep(1000);
        log.info("=================== 저장 후, commonName = {}, threadLocalName = {}", commonNameStore, nameThreadLocalStore.get());
    }

    private void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
