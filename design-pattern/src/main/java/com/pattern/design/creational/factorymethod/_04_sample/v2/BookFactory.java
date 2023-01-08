package com.pattern.design.creational.factorymethod._04_sample.v2;

public class BookFactory extends DefaultProductFactory {
    @Override
    public Product createByType(String type, String name, int price) {
        validateProductType(type);
        return new Book(type, name, price);
    }

    @Override
    public void validateProductType(String type) {
        if (!type.equalsIgnoreCase("book")) {
            throw new IllegalArgumentException("해당 상품은 책이 아닙니다.");
        }
    }
}
