package com.pattern.design.creational.singleton;

public class SingletonC {

    private static final SingletonC INSTANCE;

    static {
        try {
            INSTANCE = new SingletonC();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private SingletonC() throws Exception {
        throw new Exception();
    }

    public static SingletonC getInstance() {
        return INSTANCE;
    }
}
