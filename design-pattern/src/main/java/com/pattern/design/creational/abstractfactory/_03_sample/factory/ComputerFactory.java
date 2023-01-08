package com.pattern.design.creational.abstractfactory._03_sample.factory;

import com.pattern.design.creational.abstractfactory._03_sample.domain.*;

public class ComputerFactory {

    private ComputerPartFactory partFactory = null;

    public Computer createComputer(String type) {
        switch (type) {
            case "LG":
                partFactory = new LGComputerPartFactory();
                return new LGComputer(
                        partFactory.createMonitor(),
                        partFactory.createKeyboard(),
                        partFactory.createMouse()
                );
            case "Samsung":
                partFactory = new SamsungComputerPartFactory();
                return new SamsungComputer(
                        partFactory.createMonitor(),
                        partFactory.createKeyboard(),
                        partFactory.createMouse()
                );
            default: return null;
        }
    }
}
