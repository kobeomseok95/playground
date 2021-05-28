package com.example.jpashop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("movie")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends Item {

    private String director;
    private String distributor;
}
