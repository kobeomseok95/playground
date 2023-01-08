package com.pattern.design.creational.factorymethod._03_java;

public class SimpleFactory {

    public Object createProduct(String name) {
        if (name.equals("ALBUM")) {
            return new Album(name);
        } else if (name.equals("BOOK")) {
            return new Book(name);
        }

        throw new IllegalArgumentException("상품 유형이 아닙니다.");
    }

    static class Album {
        private String name;

        public Album(String name) {
            this.name = name;
        }
    }

    static class Book {
        private String name;

        public Book(String name) {
            this.name = name;
        }
    }
}
