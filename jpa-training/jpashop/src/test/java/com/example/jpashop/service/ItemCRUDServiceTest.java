package com.example.jpashop.service;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.service.item.ItemService;
import com.example.jpashop.util.ItemMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemCRUDServiceTest {

    @Spy ItemRepository itemRepository;
    @Spy List<ItemService> itemServices;
    @Spy ItemMapper itemMapper;
    @Spy @InjectMocks ItemCRUDService itemCRUDService;

    @Test
    @DisplayName("전체 아이템 페이징 조회")
    void getItems() throws Exception {

        // given
        PageRequest pageRequest = mock(PageRequest.class);
        Page<Item> items = mock(Page.class);
        when(itemRepository.findAll(pageRequest)).thenReturn(items);

        // when
        itemCRUDService.getItems(pageRequest);

        // then
        verify(itemRepository).findAll(pageRequest);
        verify(items, atLeastOnce()).map(any());
    }

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

    @Test
    @DisplayName("앨범 수정")
    void updateAlbum() throws Exception {

        // given
        ItemDto.AlbumDto request = mock(ItemDto.AlbumDto.class);
        Album album = mock(Album.class);
        when(itemRepository.findById(anyLong())).thenReturn(Optional.of(album));

        // when
        itemCRUDService.updateItem("1", request);

        // then
        verify(itemRepository).findById(anyLong());
        verify(album).updateAlbum(request);
    }

    @Test
    @DisplayName("책 수정")
    void updateBook() throws Exception {

        // given
        ItemDto.BookDto request = mock(ItemDto.BookDto.class);
        Book book = mock(Book.class);
        when(itemRepository.findById(anyLong())).thenReturn(Optional.of(book));

        // when
        itemCRUDService.updateItem("1", request);

        // then
        verify(itemRepository).findById(anyLong());
        verify(book).updateBook(request);
    }

    @Test
    @DisplayName("영화 수정")
    void updateMovie() throws Exception {

        // given
        ItemDto.MovieDto request = mock(ItemDto.MovieDto.class);
        Movie movie = mock(Movie.class);
        when(itemRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        // when
        itemCRUDService.updateItem("1", request);

        // then
        verify(itemRepository).findById(anyLong());
        verify(movie).updateMovie(request);
    }

    @Test
    @DisplayName("상품(아무거나) 삭제")
    void deleteItem() throws Exception {

        // given, when
        itemCRUDService.deleteItem("1");

        // then
        verify(itemRepository).deleteById(anyLong());
    }
}