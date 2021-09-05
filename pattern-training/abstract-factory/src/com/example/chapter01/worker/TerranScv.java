package com.example.chapter01.worker;

public class TerranScv extends Worker{

    public TerranScv() {
        super(60);
    }

    @Override
    public void build() {
        System.out.println("건물 짓기");
    }

    @Override
    public void gather() {
        System.out.println("미네랄 채굴");
    }
}
