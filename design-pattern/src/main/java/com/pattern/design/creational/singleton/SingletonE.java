package com.pattern.design.creational.singleton;

import java.io.*;

public class SingletonE implements Serializable {

    private SingletonE () {
        System.out.println("SingletonE.SingletonE 생성자 호출");
    }

    private static class SingletonEHolder {
        private static final SingletonE INSTANCE = new SingletonE();
    }

    public static SingletonE getInstance() {
        return SingletonEHolder.INSTANCE;
    }
}
