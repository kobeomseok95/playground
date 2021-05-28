package com.example.jpashop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book extends Item {

    private String author;
    private String isbn;
}
