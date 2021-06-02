package com.example.jpashop.service.item;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.repository.CategoryRepository;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.util.MovieMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MovieItemServiceTest {

    @Mock MovieMapper movieMapper;
    @Mock CategoryRepository categoryRepository;
    @Mock ItemRepository itemRepository;

    @Spy @InjectMocks MovieItemService movieItemService;

    @Test
    @DisplayName("영화 생성")
    void createMovie() throws Exception {

        // given
        ItemDto.MovieDto request = ItemDto.MovieDto.builder()
                .name("").price(1).stockQuantity(1).categoryId("1").itemType(ItemDto.ItemType.MOVIE)
                .director("G")
                .distributor("g")
                .build();
        Movie movie = mock(Movie.class);
        Category category = mock(Category.class);

        when(movieMapper.movieDtoToMovie(request)).thenReturn(movie);
        when(categoryRepository.findByIdFetch(anyLong())).thenReturn(Optional.of(category));

        // when
        movieItemService.createItem(request);

        // then
        verify(movieMapper).movieDtoToMovie(request);
        verify(categoryRepository).findByIdFetch(anyLong());
        verify(itemRepository).save(movie);
        verify(category).addCategoryItem(any(CategoryItem.class));
        verify(movie).addCategoryItem(any(CategoryItem.class));
    }
}