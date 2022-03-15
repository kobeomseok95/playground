package com.mapping.relation.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompositeService {

    private ThreadLocal<String> nameThreadLocalStore = new ThreadLocal<>();
    private String commonNameStore;

    public void logic(String name) {
        log.info("=================== 저장 전, commonName = {}, threadLocalName = {}", commonNameStore, nameThreadLocalStore.get());
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
