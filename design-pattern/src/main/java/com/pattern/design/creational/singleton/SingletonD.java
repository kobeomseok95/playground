package com.pattern.design.creational.singleton;

public class SingletonD {

    private static SingletonD instance;

    private SingletonD() { }

    public static SingletonD getInstance() {
        if (instance == null) {
            synchronized (SingletonD.class) {
                if (instance == null) {
                    instance = new SingletonD();
                }
            }
        }
        return instance;
    }
}
