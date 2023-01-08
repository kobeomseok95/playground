package com.pattern.design.creational.factorymethod._04_sample;

import com.pattern.design.creational.factorymethod._04_sample.v2.AlbumFactory;
import com.pattern.design.creational.factorymethod._04_sample.v2.BookFactory;
import com.pattern.design.creational.factorymethod._04_sample.v2.Product;
import com.pattern.design.creational.factorymethod._04_sample.v2.ProductFactory;

public class Client {
    public static void main(String[] args) {
        printResult(new AlbumFactory(), "album", "음반", 10_000);
        printResult(new BookFactory(), "book", "책", 20_000);
    }

    private static void printResult(ProductFactory productFactory, String type, String name, int price) {
        Product product = productFactory.createProduct(type, name, price);
        System.out.println(product);
    }
}
