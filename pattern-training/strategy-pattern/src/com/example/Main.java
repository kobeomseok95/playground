package com.example;

import com.example.chapter01.Chapter01Main;
import com.example.chapter01.Character;
import com.example.chapter01.Gun;
import com.example.chapter01.Sword;
import com.example.chapter02.Chapter02Main;

public class Main {

    public static void main(String[] args) {
        Chapter01Main main1 = new Chapter01Main();
        main1.main();

        System.out.println("=========================================");

        Chapter02Main main2 = new Chapter02Main();
        main2.main();
    }
}
