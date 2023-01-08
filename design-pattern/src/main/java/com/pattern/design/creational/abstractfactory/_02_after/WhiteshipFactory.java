package com.pattern.design.creational.abstractfactory._02_after;

import com.pattern.design.creational.abstractfactory._01_before.WhiteAnchor;
import com.pattern.design.creational.abstractfactory._01_before.WhiteWheel;
import com.pattern.design.creational.factorymethod._02_after.entity.Ship;
import com.pattern.design.creational.factorymethod._02_after.entity.WhiteShip;
import com.pattern.design.creational.factorymethod._02_after.factory.v8.DefaultShipFactoryV8;

public class WhiteshipFactory extends DefaultShipFactoryV8 {

    private ShipPartsFactory shipPartsFactory;

    public WhiteshipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
//        ship.setAnchor(shipPartsFactory.createAnchor());
//        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
