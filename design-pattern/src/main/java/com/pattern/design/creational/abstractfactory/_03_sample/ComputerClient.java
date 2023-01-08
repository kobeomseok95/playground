package com.pattern.design.creational.abstractfactory._03_sample;

import com.pattern.design.creational.abstractfactory._03_sample.domain.Computer;
import com.pattern.design.creational.abstractfactory._03_sample.factory.ComputerFactory;

public class ComputerClient {

    public static void main(String[] args) {
        ComputerFactory factory = new ComputerFactory();
        Computer computer1 = factory.createComputer("LG");
        System.out.println("computer1 = " + computer1);

        Computer computer2 = factory.createComputer("Samsung");
        System.out.println("computer2 = " + computer2);
    }
}
