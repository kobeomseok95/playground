package com.example.chapter01.worker;

import com.example.chapter01.behavior.Buildable;
import com.example.chapter01.behavior.Gatherable;

public abstract class Worker implements Gatherable, Buildable {

    private int hp;
    private int power;

    public Worker(int hp) {
        this.hp = hp;
        this.power = 5;
    }

    public void printInfo() {
        System.out.println("이 일꾼의 체력은 " + this.hp + "이며 공격력은 " + this.power + "입니다.");
    }
}
