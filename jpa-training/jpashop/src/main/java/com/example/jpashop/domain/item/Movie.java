package com.example.jpashop.domain.item;

import com.example.jpashop.dto.ItemDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("movie")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public class Movie extends Item {

    private String director;
    private String distributor;

    public void updateMovie(ItemDto.MovieDto request) {
        this.director = request.getDirector();
        this.distributor = request.getDistributor();
        this.updateItem(request);
    }
}
