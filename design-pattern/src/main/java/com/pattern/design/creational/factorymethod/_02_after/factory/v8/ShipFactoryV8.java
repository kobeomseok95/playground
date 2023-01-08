package com.pattern.design.creational.factorymethod._02_after.factory.v8;

import com.pattern.design.creational.factorymethod._02_after.entity.Ship;

// at java8
public interface ShipFactoryV8 {
    default Ship orderShip(String name, String email) {
        validateName(name);
        validateEmail(email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }

    Ship createShip();

    void validateName(String name);

    void validateEmail(String email);

    void prepareFor(String name);

    void sendEmailTo(String email, Ship ship);
}
