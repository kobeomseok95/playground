package com.example.item.factory;

import com.example.item.Item;
import com.example.item.MpPotion;

import java.util.UUID;

public class MpPotionFactory extends ItemFactory {

    @Override
    protected Item setRecoveryAmount(String itemId, int recoveryAmount) {
        return new MpPotion(itemId, recoveryAmount);
    }
}
