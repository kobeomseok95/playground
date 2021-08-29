package com.example.item;

import com.example.item.factory.HpPotionFactory;
import com.example.user.User;

public class HpPotion implements Item {

    private PotionType potionType;
    private String itemId;
    private int recoveryAmount;

    private HpPotion() { }

    public HpPotion(String itemId, int recoveryAmount) {
        this.itemId = itemId;
        this.recoveryAmount = recoveryAmount;
        this.potionType = PotionType.HP;
    }

    @Override
    public int getRecoveryAmount() {
        return recoveryAmount;
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    @Override
    public PotionType getPotionType() {
        return potionType;
    }
}
