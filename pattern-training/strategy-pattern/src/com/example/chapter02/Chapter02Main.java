package com.example.chapter02;

public class Chapter02Main {

    public void main() {
        Moving train = new Train();
        Moving bus = new Bus();

        /**
         *      1. 기차가 선로를 통해 이동
         *      2. 버스가 육로를 통해 이동
         */
        train.setMovableStrategy(new RailLoadStrategy());
        bus.setMovableStrategy(new LoadStrategy());
        train.move();
        bus.move();

        /**
         *      요구사항 변경
         *          버스가 선로를 통해 이동한다.
         */
        bus.setMovableStrategy(new RailLoadStrategy());
        bus.move();
    }
}
