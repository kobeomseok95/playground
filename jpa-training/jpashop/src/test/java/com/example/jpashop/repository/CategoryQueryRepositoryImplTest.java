package com.example.jpashop.repository;

import com.example.jpashop.TestConfig;
import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Movie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestConfig.class)
class CategoryQueryRepositoryImplTest {

    @Autowired CategoryRepository categoryRepository;
    @Autowired ItemRepository itemRepository;
    @Autowired EntityManager em;

    @Test
    @DisplayName("카테고리 안에 있는 아이템들 가져오기")
    void findByParentIdIsNull() {

        // given
        Album item1 = Album.builder().name("앨범1").price(1000).stockQuantity(1000).artist("범석").genre("힙합").build();
        Book item2 = Book.builder().name("책1").price(2000).stockQuantity(2000).author("범석").isbn("123").build();
        Movie item3 = Movie.builder().name("영화").price(3000).stockQuantity(3000).distributor("범석회사").director("범석").build();
        Album item4 = Album.builder().name("앨범2").price(1000).stockQuantity(1000).artist("범석").genre("힙합").build();
        Album item5 = Album.builder().name("앨범3").price(1000).stockQuantity(1000).artist("범석").genre("힙합").build();

        Category album = Category.builder().name("ALBUM").build();
        Category book = Category.builder().name("BOOK").build();
        Category movie = Category.builder().name("MOVIE").build();

        CategoryItem ci1 = CategoryItem.builder().category(album).item(item1).build();
        CategoryItem ci2 = CategoryItem.builder().category(album).item(item4).build();
        CategoryItem ci3 = CategoryItem.builder().category(album).item(item5).build();
        CategoryItem ci4 = CategoryItem.builder().category(book).item(item2).build();
        CategoryItem ci5 = CategoryItem.builder().category(movie).item(item3).build();

        album.addCategoryItem(ci1); album.addCategoryItem(ci2); album.addCategoryItem(ci3);
        book.addCategoryItem(ci4); movie.addCategoryItem(ci5);

        categoryRepository.saveAll(List.of(album, book, movie));
        itemRepository.saveAll(List.of(item1, item2, item3, item4, item5));
        em.flush(); em.clear();

        // 연관관계 고려
        Category horror = Category.builder().name("HORROR").build();
        horror.addParent(movie);
        categoryRepository.save(horror);

        // when
        List<Category> categoryList = categoryRepository.findByParentIdIsNull();

        // then
        assertAll(
                () -> assertEquals(categoryList.size(), 3),
                () -> assertThat(categoryList).extracting("name").contains("ALBUM", "BOOK", "MOVIE"));
    }

    @Test
    @DisplayName("categoryItems 한번에 fetch로 가져오기기")
    void findByIdFetch() {

        // given
        Album item1 = Album.builder().name("앨범1").price(1000).stockQuantity(1000).artist("범석").genre("힙합").build();
        Book item2 = Book.builder().name("책1").price(2000).stockQuantity(2000).author("범석").isbn("123").build();
        Movie item3 = Movie.builder().name("영화").price(3000).stockQuantity(3000).distributor("범석회사").director("범석").build();
        Album item4 = Album.builder().name("앨범2").price(1000).stockQuantity(1000).artist("범석").genre("힙합").build();
        Album item5 = Album.builder().name("앨범3").price(1000).stockQuantity(1000).artist("범석").genre("힙합").build();

        Category album = Category.builder().name("ALBUM").build();
        Category book = Category.builder().name("BOOK").build();
        Category movie = Category.builder().name("MOVIE").build();

        CategoryItem ci1 = CategoryItem.builder().category(album).item(item1).build();
        CategoryItem ci2 = CategoryItem.builder().category(album).item(item4).build();
        CategoryItem ci3 = CategoryItem.builder().category(album).item(item5).build();
        CategoryItem ci4 = CategoryItem.builder().category(book).item(item2).build();
        CategoryItem ci5 = CategoryItem.builder().category(movie).item(item3).build();

        album.addCategoryItem(ci1); album.addCategoryItem(ci2); album.addCategoryItem(ci3);
        book.addCategoryItem(ci4); movie.addCategoryItem(ci5);

        categoryRepository.saveAll(List.of(album, book, movie));
        itemRepository.saveAll(List.of(item1, item2, item3, item4, item5));
        em.flush(); em.clear();

        // 연관관계 고려
        Category horror = Category.builder().name("HORROR").build();
        horror.addParent(movie);
        categoryRepository.save(horror);

        // when
        Category category = categoryRepository.findByIdFetch(album.getId()).orElseThrow();

        // then
        List<CategoryItem> ci = category.getCategoryItems();
        assertEquals(ci.size(), 3);
    }
}