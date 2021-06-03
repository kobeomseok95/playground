package com.example.jpashop.util;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.ItemDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ItemMapper {

    ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    ItemDto.AlbumDto map(Album album);

    ItemDto.BookDto map(Book book);

    ItemDto.MovieDto map(Movie movie);

    default Album map(ItemDto.AlbumDto request) {
        return Album.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .artist(request.getArtist())
                .genre(request.getGenre())
                .build();
    }

    default Book map(ItemDto.BookDto request) {
        return Book.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .build();
    }

    default Movie map(ItemDto.MovieDto request) {
        return Movie.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .director(request.getDirector())
                .distributor(request.getDistributor())
                .build();
    }
}
