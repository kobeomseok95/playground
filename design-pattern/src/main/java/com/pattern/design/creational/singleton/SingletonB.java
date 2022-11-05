package com.pattern.design.creational.singleton;

public class SingletonB {

    private static SingletonB instance;

    private SingletonB() { }

    public static synchronized SingletonB getInstance() {
        if (instance == null) {
            instance = new SingletonB();
        }
        return instance;
    }
}
