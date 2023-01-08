package com.pattern.design.creational.abstractfactory._03_sample.domain;

public class SamsungComputer extends Computer {
    public SamsungComputer(Monitor monitor, Keyboard keyboard, Mouse mouse) {
        super(keyboard, monitor, mouse);
    }

    @Override
    public String toString() {
        return "이 컴퓨터는 삼성 컴퓨터입니다.";
    }
}
