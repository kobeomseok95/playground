package com.example;

import com.example.chapter01.Character;
import com.example.chapter01.Gun;
import com.example.chapter01.Sword;

public class Main {

    public static void main(String[] args) {
        Character character1 = new Character(new Gun());
        character1.attack();

        Character character2 = new Character(new Sword());
        character2.attack();
    }
}
