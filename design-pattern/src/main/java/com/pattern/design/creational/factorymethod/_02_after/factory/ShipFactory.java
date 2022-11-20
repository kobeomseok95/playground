package com.pattern.design.creational.factorymethod._02_after.factory;

import com.pattern.design.creational.factorymethod._02_after.entity.Ship;

public interface ShipFactory {
    default Ship orderShip(String name, String email) {
        validateName(name);
        validateEmail(email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 입력해주세요.");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("이메일을 입력해주세요.");
        }
    }

    private void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    }

    Ship createShip();

    private void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }
}
