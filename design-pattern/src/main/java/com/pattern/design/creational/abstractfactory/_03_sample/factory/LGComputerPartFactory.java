package com.pattern.design.creational.abstractfactory._03_sample.factory;

import com.pattern.design.creational.abstractfactory._03_sample.domain.*;

public class LGComputerPartFactory implements ComputerPartFactory {

    @Override
    public Monitor createMonitor() {
        return new LGMonitor();
    }

    @Override
    public Mouse createMouse() {
        return new LGMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new LGKeyboard();
    }
}
