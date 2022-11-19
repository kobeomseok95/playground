package com.pattern.design.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonE implements Serializable {

    private SingletonE () { }

    private static class SingletonEHolder {
        private static final SingletonE INSTANCE = new SingletonE();
    }

    public static SingletonE getInstance() {
        return SingletonEHolder.INSTANCE;
    }
}
