package com.example.jpashop.util;

import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.ItemDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MovieMapper {

    MovieMapper movieMapper = Mappers.getMapper(MovieMapper.class);

    Movie movieDtoToMovie(ItemDto.MovieDto request);
}
