package com.example.item.factory;

import com.example.item.Item;

import java.util.UUID;

public abstract class ItemFactory {

    public Item createItem(int recoveryAmount) {
        String itemId = generateUUID();
        return setRecoveryAmount(itemId, recoveryAmount);
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }

    abstract protected Item setRecoveryAmount(String itemId, int recoveryAmount);
}
