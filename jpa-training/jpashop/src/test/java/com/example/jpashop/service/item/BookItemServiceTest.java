package com.example.jpashop.service.item;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.repository.CategoryRepository;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.util.BookMapper;
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
class BookItemServiceTest {

    @Mock ItemRepository itemRepository;
    @Mock CategoryRepository categoryRepository;
    @Mock BookMapper bookMapper;

    @Spy @InjectMocks BookItemService bookItemService;

    @Test
    @DisplayName("책 생성")
    void createBook() throws Exception {

        // given
        ItemDto.BookDto request = ItemDto.BookDto.builder()
                .name("").price(1).stockQuantity(1).categoryId("1").itemType(ItemDto.ItemType.BOOK)
                .author("G")
                .isbn("g")
                .build();
        Book book = mock(Book.class);
        Category category = mock(Category.class);

        when(bookMapper.bookDtoToBook(request)).thenReturn(book);
        when(categoryRepository.findByIdFetch(anyLong())).thenReturn(Optional.of(category));

        // when
        bookItemService.createItem(request);

        // then
        verify(bookMapper).bookDtoToBook(request);
        verify(categoryRepository).findByIdFetch(anyLong());
        verify(itemRepository).save(book);
        verify(category).addCategoryItem(any(CategoryItem.class));
        verify(book).addCategoryItem(any(CategoryItem.class));
    }
}