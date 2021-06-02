package com.example.jpashop.util;

import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Book.BookBuilder;
import com.example.jpashop.dto.ItemDto.BookDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-02T20:25:42+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book bookDtoToBook(BookDto request) {
        if ( request == null ) {
            return null;
        }

        BookBuilder<?, ?> book = Book.builder();

        book.name( request.getName() );
        book.price( request.getPrice() );
        book.stockQuantity( request.getStockQuantity() );
        book.author( request.getAuthor() );
        book.isbn( request.getIsbn() );

        return book.build();
    }
}
