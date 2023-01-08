package com.pattern.design.creational.abstractfactory._03_sample.domain;

public class LGComputer extends Computer {

    public LGComputer(Monitor monitor, Keyboard keyboard, Mouse mouse) {
        super(keyboard, monitor, mouse);
    }

    @Override
    public String toString() {
        return "이 컴퓨터는 LG 컴퓨터입니다.";
    }
}
