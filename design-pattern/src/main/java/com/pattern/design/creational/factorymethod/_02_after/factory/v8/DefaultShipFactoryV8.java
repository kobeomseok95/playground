package com.pattern.design.creational.factorymethod._02_after.factory.v8;


import com.pattern.design.creational.factorymethod._02_after.entity.Ship;

// at java 8
public abstract class DefaultShipFactoryV8 implements ShipFactoryV8 {
    @Override
    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 입력해주세요.");
        }
    }

    @Override
    public void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("이메일을 입력해주세요.");
        }
    }

    @Override
    public void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    }

    @Override
    public void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }
}
