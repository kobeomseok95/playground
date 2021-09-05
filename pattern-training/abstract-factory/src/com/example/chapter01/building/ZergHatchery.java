package com.example.chapter01.building;

public class ZergHatchery extends Building{

    @Override
    public void createWorker() {
        System.out.println("드론 생성");
    }
}
