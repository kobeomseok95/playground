package com.example.item;

import com.example.user.User;

public class MpPotion implements Item {

    private PotionType potionType;
    private String itemId;
    private int recoveryAmount;

    private MpPotion() { }

    public MpPotion(String itemId, int recoveryAmount) {
        this.itemId = itemId;
        this.recoveryAmount = recoveryAmount;
        this.potionType = PotionType.MP;
    }

    @Override
    public int getRecoveryAmount() {
        return recoveryAmount;
    }

    @Override
    public String getItemId() {
        return this.itemId;
    }

    @Override
    public PotionType getPotionType() {
        return potionType;
    }
}
