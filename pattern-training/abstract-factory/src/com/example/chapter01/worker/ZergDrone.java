package com.example.chapter01.worker;

public class ZergDrone extends Worker{

    public ZergDrone() {
        super(40);
    }

    @Override
    public void build() {
        System.out.println("크립에 파고 들어가기(건물 짓기 준비)");
    }

    @Override
    public void gather() {
        System.out.println("집게로 미네랄 집기");
    }
}
