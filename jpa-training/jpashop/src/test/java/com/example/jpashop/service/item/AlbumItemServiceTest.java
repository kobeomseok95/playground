package com.example.jpashop.service.item;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.domain.item.Album;
import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.repository.CategoryRepository;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.util.AlbumMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlbumItemServiceTest {

    @Mock AlbumMapper albumMapper;
    @Mock ItemRepository itemRepository;
    @Mock CategoryRepository categoryRepository;
    @InjectMocks AlbumItemService albumItemService;

    @Test
    @DisplayName("앨범 생성")
    void createAlbum() throws Exception {

        // given
        ItemDto.AlbumDto request = ItemDto.AlbumDto.builder()
                .name("").price(1).stockQuantity(1).categoryId("1").itemType(ItemDto.ItemType.ALBUM)
                .artist("G")
                .genre("g")
                .build();
        Album album = mock(Album.class);
        Category category = mock(Category.class);

        when(albumMapper.albumDtoToAlbum(request)).thenReturn(album);
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));

        // when
        albumItemService.createItem(request);

        // then
        verify(albumMapper).albumDtoToAlbum(request);
        verify(categoryRepository).findById(anyLong());
        verify(itemRepository).save(album);
        verify(category).addCategoryItem(any(CategoryItem.class));
        verify(album).addCategoryItem(any(CategoryItem.class));
    }
}