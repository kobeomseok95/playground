package com.example;

import com.example.item.HpPotion;
import com.example.item.Item;
import com.example.item.factory.HpPotionFactory;
import com.example.item.factory.ItemFactory;
import com.example.item.factory.MpPotionFactory;
import com.example.user.User;

public class Main {

    /**
     * TODO 요구사항
     *      아이템
     *          - HP 물약
     *          - MP 물약
     *          - 고유 값 (UUID)
     *          - 생성된 아이템은 절대 변할 수 없다.
     *          - 생성 시 회복량을 줄 수 있다.
     *      유저
     *          - 닉네임
     *          - HP
     *          - MP
     *          - 인벤토리
     *      시나리오
     *          - HP 물약을 생성한다.
     *          - MP 물약을 생성한다.
     *          - HP 물약을 습득한다.
     *          - MP 물약을 습득한다.
     *          - HP 물약을 사용한다. 이 때, 현재 HP를 출력
     *          - MP 물약을 사용한다. 이 때, 현재 MP를 출력
     * @param args
     */
    public static void main(String[] args) {

        User user = new User("고범석");

        HpPotionFactory hpPotionFactory = new HpPotionFactory();
        Item hp = hpPotionFactory.createItem(200);

        MpPotionFactory mpPotionFactory = new MpPotionFactory();
        Item mp = mpPotionFactory.createItem(100);

        user.getItem(hp);
        user.getItem(mp);

        user.useItem(hp);
        user.useItem(mp);
    }
}
