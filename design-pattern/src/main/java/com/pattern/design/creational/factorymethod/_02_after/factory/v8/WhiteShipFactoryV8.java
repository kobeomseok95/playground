package com.pattern.design.creational.factorymethod._02_after.factory.v8;

import com.pattern.design.creational.factorymethod._02_after.entity.Ship;
import com.pattern.design.creational.factorymethod._02_after.entity.WhiteShip;

public class WhiteShipFactoryV8 extends DefaultShipFactoryV8 {
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
