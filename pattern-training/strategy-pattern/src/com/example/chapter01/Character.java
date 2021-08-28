package com.example.chapter01;

public class Character {

    private Weapon weapon;

    public Character(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack() {
        if (weapon == null) {
            System.out.println("맨손 공격");
        } else {
            this.weapon.attack();
        }
    }
}
