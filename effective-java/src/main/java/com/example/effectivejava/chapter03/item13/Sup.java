package com.example.effectivejava.chapter03.item13;

public class Sup implements Cloneable {

    String type;

    public Sup() {
        this.type = "super";
    }

    public void overrideMe() {
        System.out.println("super method override me");
    }

    @Override
    protected Object clone() {
        try {
            overrideMe();
            return (Sup) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Sup Exception");
        }
    }
}
