package com.example.user;

import com.example.item.Item;
import com.example.item.PotionType;

public class Recover {

    public void up(User user, Item item) {
        if (item.getPotionType().equals(PotionType.HP)) {
            user.changeHp(item.getRecoveryAmount());
            System.out.println(user.getNickname() + " 님의 HP는 " + user.getHp());
        } else {
            user.changeMp(item.getRecoveryAmount());
            System.out.println(user.getNickname() + " 님의 MP는 " + user.getMp());
        }
    }
}
