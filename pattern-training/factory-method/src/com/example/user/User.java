package com.example.user;

import com.example.item.Item;
import com.example.item.PotionType;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int fullHp;
    private int remainHp;
    private int fullMp;
    private int remainMp;
    private String nickname;
    private List<Item> inventory;
    private Recover recover;

    public User(String nickname) {
        this.nickname = nickname;
        this.fullHp = 500;
        this.fullMp = 500;
        this.remainHp = 250;
        this.remainMp = 250;
        this.inventory = new ArrayList<>();
        this.recover = new Recover();
    }

    public String getNickname() {
        return this.nickname;
    }

    public void useItem(Item item) {
        checkInventory(item);
        use(item);
    }

    private void checkInventory(Item item) {
        if (!containsInventory(item)) {
            throw new RuntimeException("아이템이 없습니다!");
        }
    }

    private void use(Item item) {
        recover.up(this, item);
    }

    private boolean containsInventory(Item item) {
        return this.getInventory().contains(item);
    }

    public void getItem(Item item) {
        this.getInventory().add(item);
    }

    private List<Item> getInventory() {
        return this.inventory;
    }

    public void changeHp(int recoveryAmount) {
        this.remainHp += recoveryAmount;
    }

    public void changeMp(int recoveryAmount) {
        this.remainMp += recoveryAmount;
    }

    public String getHp() {
        return String.valueOf(this.remainHp);
    }

    public String getMp() {
        return String.valueOf(this.remainMp);
    }
}
