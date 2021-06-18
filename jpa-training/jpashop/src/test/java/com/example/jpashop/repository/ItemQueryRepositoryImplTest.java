package com.example.jpashop.repository;

import com.example.jpashop.TestConfig;
import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestConfig.class)
class ItemQueryRepositoryImplTest {

    @Autowired ItemRepository itemRepository;
    @Autowired CategoryRepository categoryRepository;
    @Autowired EntityManager em;

    @Test
    @DisplayName("아이템과 카테고리_아이템 fetch")
    void findByIdFetch() throws Exception {

        // given
        Album album = Album.builder().name("앨범1").price(1000).stockQuantity(1000).artist("범석").genre("힙합").build();
        Category category = Category.builder().name("ALBUM").build();
        CategoryItem categoryItem = CategoryItem.builder().category(category).item(album).build();
        album.addCategoryItem(categoryItem);
        category.addCategoryItem(categoryItem);
        categoryRepository.save(category);
        itemRepository.save(album);
        em.flush(); em.clear();

        // when
        Optional<Item> findItem = itemRepository.findByIdFetch(album.getId());

        // then
        assertAll(() -> {
            assertTrue(findItem.isPresent());
            Item item = findItem.get();

            assertTrue(item instanceof Album);
            assertEquals(item.getId(), album.getId());

            assertNotNull(item.getCategoryItems());
            List<CategoryItem> categoryItems = item.getCategoryItems();
            assertEquals(categoryItems.size(), 1);
        });
    }
}