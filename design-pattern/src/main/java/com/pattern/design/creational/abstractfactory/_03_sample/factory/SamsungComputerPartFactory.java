package com.pattern.design.creational.abstractfactory._03_sample.factory;

import com.pattern.design.creational.abstractfactory._03_sample.domain.*;

public class SamsungComputerPartFactory implements ComputerPartFactory {
    @Override
    public Monitor createMonitor() {
        return new SamsungMonitor();
    }

    @Override
    public Mouse createMouse() {
        return new SamsungMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new SamsungKeyboard();
    }
}
