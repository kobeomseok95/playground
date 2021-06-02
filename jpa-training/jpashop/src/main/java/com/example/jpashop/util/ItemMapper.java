package com.example.jpashop.util;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.service.item.AlbumItemService;
import com.example.jpashop.service.item.BookItemService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static com.example.jpashop.util.AlbumMapper.albumMapper;
import static com.example.jpashop.util.BookMapper.bookMapper;
import static com.example.jpashop.util.MovieMapper.movieMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ItemMapper {

    ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    @Mapping(source = "", target = "")
    ItemDto.AlbumDto albumToAlbumDto(Album album);

    @Mapping(source = "", target = "")
    ItemDto.BookDto bookToBookDto(Book book);

    @Mapping(source = "", target = "")
    ItemDto.MovieDto movieToMovieDto(Movie movie);
}
