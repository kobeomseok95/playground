package com.example.effectivejava.chapter03.item13;

public class Sub extends Sup {

    String temp;

    @Override
    public void overrideMe() {
        System.out.println("sub method");
        System.out.println(temp);
        type = "sub";
    }

    @Override
    protected Sub clone() {
        Sub clone = (Sub) super.clone();
        clone.temp = "temp";
        return clone;
    }
}
