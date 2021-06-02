package com.example.jpashop.util;

import com.example.jpashop.domain.item.Book;
import com.example.jpashop.dto.ItemDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

    BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

    Book bookDtoToBook(ItemDto.BookDto request);
}
