package com.pattern.design.creational.factorymethod._02_after;

import com.pattern.design.creational.factorymethod._02_after.entity.Ship;
import com.pattern.design.creational.factorymethod._02_after.factory.BlackShipFactory;
import com.pattern.design.creational.factorymethod._02_after.factory.WhiteShipFactory;

public class Client {

    public static void main(String[] args) {
        Ship whiteship = new WhiteShipFactory().orderShip("whiteship", "kobumssh@naver.com");
        System.out.println(whiteship);

        Ship blackship = new BlackShipFactory().orderShip("Blackship", "keesun@mail.com");
        System.out.println(blackship);
    }

}
