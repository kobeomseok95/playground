package com.example.jpashop.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public abstract class ItemDto {

    private String name;
    private int price;
    private int stockQuantity;
    private String categoryId;
    private ItemType itemType;

    public enum ItemType {
        ALBUM, BOOK, MOVIE;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class AlbumDto extends ItemDto {

        private String artist;
        private String genre;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class BookDto extends ItemDto {

        private String author;
        private String isbn;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class MovieDto extends ItemDto {

        private String director;
        private String distributor;
    }
}
