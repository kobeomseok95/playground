package com.example.jpashop.util;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Album.AlbumBuilder;
import com.example.jpashop.dto.ItemDto.AlbumDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-02T20:25:42+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class AlbumMapperImpl implements AlbumMapper {

    @Override
    public Album albumDtoToAlbum(AlbumDto request) {
        if ( request == null ) {
            return null;
        }

        AlbumBuilder<?, ?> album = Album.builder();

        album.name( request.getName() );
        album.price( request.getPrice() );
        album.stockQuantity( request.getStockQuantity() );
        album.artist( request.getArtist() );
        album.genre( request.getGenre() );

        return album.build();
    }
}
