package com.example.chapter02;

public class LoadStrategy implements MovableStrategy{


    @Override
    public void move() {
        System.out.println("육로를 통해 이동");
    }
}
