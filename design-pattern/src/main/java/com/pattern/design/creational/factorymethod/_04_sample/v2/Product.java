package com.pattern.design.creational.factorymethod._04_sample.v2;

public abstract class Product {
    private String type;
    private String name;
    private int price;

    public Product(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[type = " + type + ", name = " + name + ", price = " + price + "]";
    }
}
