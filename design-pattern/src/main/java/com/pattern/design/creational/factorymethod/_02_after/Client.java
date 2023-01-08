package com.pattern.design.creational.factorymethod._02_after;

import com.pattern.design.creational.factorymethod._02_after.factory.v8.BlackShipFactoryV8;
import com.pattern.design.creational.factorymethod._02_after.factory.v8.ShipFactoryV8;
import com.pattern.design.creational.factorymethod._02_after.factory.v8.WhiteShipFactoryV8;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.print(new WhiteShipFactoryV8(), "whiteship", "kobumssh@naver.com");
        client.print(new BlackShipFactoryV8(), "blackship", "keesun@mail.com");
    }

    private void print(ShipFactoryV8 shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
