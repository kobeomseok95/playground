package com.example.jpashop.domain.item;

import com.example.jpashop.dto.ItemDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Book extends Item {

    private String author;
    private String isbn;

    public void updateBook(ItemDto.BookDto request) {
        this.author = request.getAuthor();
        this.isbn = request.getIsbn();
        this.updateItem(request);
    }
}
