package com.example.client;

import com.example.cafe.Cafe;

public class Client {

    private String name;
    private Cafe cafe;

    // 먼저 클라이언트를 생성
    public Client(String name) {
        this.name = name;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public String getName() {
        return name;
    }

    public Cafe getCafe() {
        return cafe;
    }
}
