package com.pattern.design.creational.factorymethod._04_sample.v2;

public class AlbumFactory extends DefaultProductFactory {
    @Override
    public Product createByType(String type, String name, int price) {
        validateProductType(type);
        return new Album(type, name, price);
    }

    @Override
    public void validateProductType(String type) {
        if (!type.equalsIgnoreCase("album")) {
            throw new IllegalArgumentException("해당 상품은 음반이 아닙니다.");
        }
    }
}
