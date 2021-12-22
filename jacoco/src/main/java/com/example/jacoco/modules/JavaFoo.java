package com.example.jacoco.modules;

public class JavaFoo {

    public String hello(String name) {
        switch (name) {
            case "펭":
                return "하";
            case "hello":
                return "world";
            default:
                return "None";
        }
    }

    public void callMe() {
        System.out.println("Please, call me.");
    }
}
