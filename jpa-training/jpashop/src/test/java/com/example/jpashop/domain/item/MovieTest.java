package com.example.jpashop.domain.item;

import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.dummy.ItemDummy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    ItemDummy itemDummy = new ItemDummy();

    @Test
    @DisplayName("영화 수정")
    void updateMovie() throws Exception {

        // given
        Movie movie = itemDummy.createMovie();
        ItemDto.MovieDto request = ItemDto.MovieDto.builder()
                .name("수정").price(10).itemType(ItemDto.ItemType.MOVIE)
                .stockQuantity(10).distributor("수정").director("수정").build();

        // when
        movie.updateMovie(request);

        // then
        assertAll(
                () -> assertEquals(movie.getName(), request.getName()),
                () -> assertEquals(movie.getPrice(), request.getPrice()),
                () -> assertEquals(movie.getStockQuantity(), request.getStockQuantity()),
                () -> assertEquals(movie.getDirector(), request.getDirector()),
                () -> assertEquals(movie.getDistributor(), request.getDistributor())
        );
    }
}
