package com.pattern.design.creational.factorymethod._04_sample.v1;

public class Product {

    private String type;
    private String name;
    private int price;

    public Product(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "[type = " + type + ", name = " + name + ", price = " + price + "]";
    }
}
