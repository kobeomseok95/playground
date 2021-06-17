package com.example.jpashop.util;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.ItemDto.AlbumDto;
import com.example.jpashop.dto.ItemDto.BookDto;
import com.example.jpashop.dto.ItemDto.MovieDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T15:46:28+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public AlbumDto map(Album album) {
        if ( album == null ) {
            return null;
        }

        AlbumDto albumDto = new AlbumDto();

        albumDto.setName( album.getName() );
        albumDto.setPrice( album.getPrice() );
        albumDto.setStockQuantity( album.getStockQuantity() );
        albumDto.setArtist( album.getArtist() );
        albumDto.setGenre( album.getGenre() );

        return albumDto;
    }

    @Override
    public BookDto map(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setName( book.getName() );
        bookDto.setPrice( book.getPrice() );
        bookDto.setStockQuantity( book.getStockQuantity() );
        bookDto.setAuthor( book.getAuthor() );
        bookDto.setIsbn( book.getIsbn() );

        return bookDto;
    }

    @Override
    public MovieDto map(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDto movieDto = new MovieDto();

        movieDto.setName( movie.getName() );
        movieDto.setPrice( movie.getPrice() );
        movieDto.setStockQuantity( movie.getStockQuantity() );
        movieDto.setDirector( movie.getDirector() );
        movieDto.setDistributor( movie.getDistributor() );

        return movieDto;
    }
}
