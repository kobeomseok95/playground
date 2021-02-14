package com.example.demo.ex02_EventExample;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderUser;
    private String product;
    private int price;
    private boolean success;
    private boolean cancel;

    public static Order success(final String user, final String product, final int price) {
        return new Order(user, product, price, true, false);
    }

    public static Order fail(final String user, final String product, final int price) {
        return new Order(user, product, price, false, false);
    }

    public static Order cancel(String user, String product, int price){
        return new Order(user, product, price, true, true);
    }
}
