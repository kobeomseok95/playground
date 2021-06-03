package com.example.jpashop.domain.item;

import com.example.jpashop.dto.ItemDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("album")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public class Album extends Item {

    private String artist;
    private String genre;

    public void updateAlbum(ItemDto.AlbumDto request) {
        this.artist = request.getArtist();
        this.genre = request.getGenre();
        this.updateItem(request);
    }
}
