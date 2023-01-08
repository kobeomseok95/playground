package com.pattern.design.creational.abstractfactory._02_after;

import com.pattern.design.creational.abstractfactory._01_before.WhiteAnchor;
import com.pattern.design.creational.abstractfactory._01_before.WhiteWheel;

public class WhiteshipPartsFactory implements ShipPartsFactory{
    @Override
    public Anchor createAnchor() { return new WhiteAnchor(); }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
