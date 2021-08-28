package com.example.chapter02;

public class Moving {

    private String name;
    private MovableStrategy movableStrategy;

    public Moving(String name) {
        this.name = name;
    }

    public void setMovableStrategy(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public void move() {
        System.out.print(this.name + "가 ");
        movableStrategy.move();
    }
}
