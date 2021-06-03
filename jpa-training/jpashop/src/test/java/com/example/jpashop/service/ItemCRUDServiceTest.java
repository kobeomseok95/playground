package com.example.jpashop.service;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.service.item.ItemService;
import com.example.jpashop.util.ItemMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemCRUDServiceTest {

    @Spy ItemRepository itemRepository;
    @Spy List<ItemService> itemServices;
    @Spy ItemMapper itemMapper;
    @InjectMocks ItemCRUDService itemCRUDService;

    @Test
    @DisplayName("앨범 조회")
    void getAlbum() throws Exception {

        // given
        Album album = mock(Album.class);
        when(itemRepository.findByIdFetch(anyLong())).thenReturn(Optional.of(album));

        // when
        itemCRUDService.getItem("1");

        // then
        verify(itemRepository).findByIdFetch(anyLong());
        verify(itemMapper).map(album);
    }

    @Test
    @DisplayName("책 조회")
    void getBook() throws Exception {

        // given
        Book book = mock(Book.class);
        when(itemRepository.findByIdFetch(anyLong())).thenReturn(Optional.of(book));

        // when
        itemCRUDService.getItem("1");

        // then
        verify(itemRepository).findByIdFetch(anyLong());
        verify(itemMapper).map(book);
    }

    @Test
    @DisplayName("영화 조회")
    void getMovie() throws Exception {

        // given
        Movie movie = mock(Movie.class);
        when(itemRepository.findByIdFetch(anyLong())).thenReturn(Optional.of(movie));

        // when
        itemCRUDService.getItem("1");

        // then
        verify(itemRepository).findByIdFetch(anyLong());
        verify(itemMapper).map(movie);
    }
}