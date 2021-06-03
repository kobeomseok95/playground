package com.example.jpashop.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.experimental.SuperBuilder;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "itemType",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "ALBUM", value = ItemDto.AlbumDto.class),
        @JsonSubTypes.Type(name = "BOOK", value = ItemDto.BookDto.class),
        @JsonSubTypes.Type(name = "MOVIE", value = ItemDto.MovieDto.class)
})
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @SuperBuilder
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
