package com.example.chapter01;

public class Gun implements Weapon{
    @Override
    public void attack() {
        System.out.println("gun attack");
    }
}
