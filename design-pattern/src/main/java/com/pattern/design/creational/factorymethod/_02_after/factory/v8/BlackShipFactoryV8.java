package com.pattern.design.creational.factorymethod._02_after.factory.v8;

import com.pattern.design.creational.factorymethod._02_after.entity.BlackShip;
import com.pattern.design.creational.factorymethod._02_after.entity.Ship;

public class BlackShipFactoryV8 extends DefaultShipFactoryV8 {
    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
