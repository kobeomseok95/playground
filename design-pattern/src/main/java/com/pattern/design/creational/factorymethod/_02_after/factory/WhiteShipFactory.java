package com.pattern.design.creational.factorymethod._02_after.factory;

import com.pattern.design.creational.factorymethod._02_after.entity.Ship;
import com.pattern.design.creational.factorymethod._02_after.entity.WhiteShip;

public class WhiteShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
