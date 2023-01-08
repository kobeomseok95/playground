package com.pattern.design.creational.abstractfactory._03_sample.factory;

import com.pattern.design.creational.abstractfactory._03_sample.domain.*;

public interface ComputerPartFactory {
    Monitor createMonitor();
    Mouse createMouse();
    Keyboard createKeyboard();
}
