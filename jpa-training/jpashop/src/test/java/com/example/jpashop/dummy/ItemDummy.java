package com.example.jpashop.dummy;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Item;


public class ItemDummy {

    public Item createAlbum() {
        return Album.builder()
                .name("고범석1집")
                .price(10000)
                .stockQuantity(200)
                .artist("고범석")
                .genre("hiphop")
                .build();
    }

//    public static Item createBook() {
//        return
//    }
//
//    public static Item createMovie() {
//        return
//    }
}
