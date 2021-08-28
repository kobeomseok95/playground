package com.example.chapter01;

public class Chapter01Main {

    public void main() {
        Character character1 = new Character(new Gun());
        character1.attack();

        Character character2 = new Character(new Sword());
        character2.attack();
    }
}
