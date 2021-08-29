package com.example.item.factory;

import com.example.item.HpPotion;
import com.example.item.Item;

import java.util.UUID;

public class HpPotionFactory extends ItemFactory {

    @Override
    protected Item setRecoveryAmount(String itemId, int recoveryAmount) {
        return new HpPotion(itemId, recoveryAmount);
    }
}
