package com.example.jpashop.util;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.ItemDto.AlbumDto;
import com.example.jpashop.dto.ItemDto.AlbumDto.AlbumDtoBuilder;
import com.example.jpashop.dto.ItemDto.BookDto;
import com.example.jpashop.dto.ItemDto.BookDto.BookDtoBuilder;
import com.example.jpashop.dto.ItemDto.MovieDto;
import com.example.jpashop.dto.ItemDto.MovieDto.MovieDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-02T20:25:42+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public AlbumDto albumToAlbumDto(Album album) {
        if ( album == null ) {
            return null;
        }

        AlbumDtoBuilder<?, ?> albumDto = AlbumDto.builder();

        albumDto.name( album.getName() );
        albumDto.price( album.getPrice() );
        albumDto.stockQuantity( album.getStockQuantity() );
        albumDto.artist( album.getArtist() );
        albumDto.genre( album.getGenre() );

        return albumDto.build();
    }

    @Override
    public BookDto bookToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDtoBuilder<?, ?> bookDto = BookDto.builder();

        bookDto.name( book.getName() );
        bookDto.price( book.getPrice() );
        bookDto.stockQuantity( book.getStockQuantity() );
        bookDto.author( book.getAuthor() );
        bookDto.isbn( book.getIsbn() );

        return bookDto.build();
    }

    @Override
    public MovieDto movieToMovieDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDtoBuilder<?, ?> movieDto = MovieDto.builder();

        movieDto.name( movie.getName() );
        movieDto.price( movie.getPrice() );
        movieDto.stockQuantity( movie.getStockQuantity() );
        movieDto.director( movie.getDirector() );
        movieDto.distributor( movie.getDistributor() );

        return movieDto.build();
    }
}
