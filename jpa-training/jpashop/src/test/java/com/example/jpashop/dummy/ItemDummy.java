package com.example.jpashop.dummy;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.Movie;


public class ItemDummy {

    public Album createAlbum() {
        return Album.builder()
                .name("고범석1집")
                .price(10000)
                .stockQuantity(200)
                .artist("고범석")
                .genre("hiphop")
                .build();
    }

    public Book createBook() {
        return Book.builder()
                .name("고범석1집")
                .price(10000)
                .stockQuantity(200)
                .author("고범석")
                .isbn("code")
                .build();
    }

    public Movie createMovie() {
        return Movie.builder()
                .name("고범석1집")
                .price(10000)
                .stockQuantity(200)
                .director("고범석")
                .distributor("누군가")
                .build();
    }
}
