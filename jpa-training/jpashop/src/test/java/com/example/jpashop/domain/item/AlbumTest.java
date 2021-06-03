package com.example.jpashop.domain.item;

import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.dummy.ItemDummy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumTest {

    ItemDummy itemDummy = new ItemDummy();

    @Test
    @DisplayName("앨범 수정")
    void updateAlbum() throws Exception {

        // given
        Album album = itemDummy.createAlbum();
        ItemDto.AlbumDto request = ItemDto.AlbumDto.builder()
                .name("수정").price(10).itemType(ItemDto.ItemType.ALBUM)
                .stockQuantity(10).artist("수정").genre("수정").build();

        // when
        album.updateAlbum(request);

        // then
        assertAll(
                () -> assertEquals(album.getName(), request.getName()),
                () -> assertEquals(album.getPrice(), request.getPrice()),
                () -> assertEquals(album.getStockQuantity(), request.getStockQuantity()),
                () -> assertEquals(album.getArtist(), request.getArtist()),
                () -> assertEquals(album.getGenre(), request.getGenre())
        );
    }
}
