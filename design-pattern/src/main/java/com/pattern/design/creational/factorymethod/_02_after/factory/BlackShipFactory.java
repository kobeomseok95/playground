package com.pattern.design.creational.factorymethod._02_after.factory;

import com.pattern.design.creational.factorymethod._02_after.entity.BlackShip;
import com.pattern.design.creational.factorymethod._02_after.entity.Ship;

public class BlackShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
