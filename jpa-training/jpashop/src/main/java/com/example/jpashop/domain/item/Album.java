package com.example.jpashop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("album")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album extends Item {

    private String artist;
    private String genre;
}
