package com.example.jpashop.util;

import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.domain.item.Movie.MovieBuilder;
import com.example.jpashop.dto.ItemDto.MovieDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-02T20:25:42+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public Movie movieDtoToMovie(MovieDto request) {
        if ( request == null ) {
            return null;
        }

        MovieBuilder<?, ?> movie = Movie.builder();

        movie.name( request.getName() );
        movie.price( request.getPrice() );
        movie.stockQuantity( request.getStockQuantity() );
        movie.director( request.getDirector() );
        movie.distributor( request.getDistributor() );

        return movie.build();
    }
}
