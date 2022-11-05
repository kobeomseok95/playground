package com.pattern.design.creational.singleton;

public class SingletonE {

    private SingletonE () { }

    private static class SingletonEHolder {
        private static final SingletonE INSTANCE = new SingletonE();
    }

    public static SingletonE getInstance() {
        return SingletonEHolder.INSTANCE;
    }
}
