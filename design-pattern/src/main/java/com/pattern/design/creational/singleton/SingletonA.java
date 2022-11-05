package com.pattern.design.creational.singleton;

public class SingletonA {

    private static SingletonA instance;

    private SingletonA() { }

    public static SingletonA getInstance() {
        if (instance == null) {
            instance = new SingletonA();
        }
        return instance;
    }
}
