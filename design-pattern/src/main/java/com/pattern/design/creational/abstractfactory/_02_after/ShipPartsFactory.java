package com.pattern.design.creational.abstractfactory._02_after;

// 추상 팩토리
public interface ShipPartsFactory {
    Anchor createAnchor();
    Wheel createWheel();
}
