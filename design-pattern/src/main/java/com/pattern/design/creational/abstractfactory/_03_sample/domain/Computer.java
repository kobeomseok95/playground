package com.pattern.design.creational.abstractfactory._03_sample.domain;

public abstract class Computer {
    Desktop desktop;
    Keyboard keyboard;
    Monitor monitor;
    Mouse mouse;

    public Computer(Keyboard keyboard, Monitor monitor, Mouse mouse) {
        this.desktop = new Desktop();
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.mouse = mouse;
    }
}
