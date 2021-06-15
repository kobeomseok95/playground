package com.example.jpashop;


import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.repository.CategoryRepository;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class DataPostConstructor {

    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;

    @PostConstruct
    void init() {

        // member 생성
        memberRepository.save(Member.builder().name("고범석")
                .address(Address.builder().city("서울시").street("광진구 중곡동").zipcode("1111").build())
                .build());

        // category 생성, 앨범/영화/책
        Category albumCategory = Category.builder().name("ALBUM").build();
        Category bookCategory = Category.builder().name("BOOK").build();
        Category movieCategory = Category.builder().name("MOVIE").build();
        categoryRepository.saveAll(List.of(albumCategory, bookCategory, movieCategory));
//        em.flush();
//        em.clear();

        // item 생성, 앨범/책/영화 각각 10개씩 총 30개
        List<Item> items = new ArrayList<>();
        items.addAll(albumGenerator(albumCategory));
        items.addAll(bookGenerator(bookCategory));
        items.addAll(movieGenerator(movieCategory));
        itemRepository.saveAll(items);
    }

    private List<Item> albumGenerator(Category albumCategory) {
        Album album1 = Album.builder().artist("가수1").genre("장르1").price(10000).stockQuantity(50000).name("앨범1").build();
        Album album2 = Album.builder().artist("가수2").genre("장르2").price(10000).stockQuantity(50000).name("앨범2").build();
        Album album3 = Album.builder().artist("가수3").genre("장르3").price(10000).stockQuantity(50000).name("앨범3").build();
        Album album4 = Album.builder().artist("가수4").genre("장르4").price(10000).stockQuantity(50000).name("앨범4").build();
        Album album5 = Album.builder().artist("가수5").genre("장르5").price(10000).stockQuantity(50000).name("앨범5").build();
        Album album6 = Album.builder().artist("가수6").genre("장르6").price(10000).stockQuantity(50000).name("앨범6").build();
        Album album7 = Album.builder().artist("가수7").genre("장르7").price(10000).stockQuantity(50000).name("앨범7").build();
        Album album8 = Album.builder().artist("가수8").genre("장르8").price(10000).stockQuantity(50000).name("앨범8").build();
        Album album9 = Album.builder().artist("가수9").genre("장르9").price(10000).stockQuantity(50000).name("앨범9").build();
        Album album10 = Album.builder().artist("가수10").genre("장르10").price(10000).stockQuantity(50000).name("앨범10").build();

        CategoryItem categoryItem1 = CategoryItem.builder().category(albumCategory).item(album1).build();
        CategoryItem categoryItem2 = CategoryItem.builder().category(albumCategory).item(album2).build();
        CategoryItem categoryItem3 = CategoryItem.builder().category(albumCategory).item(album3).build();
        CategoryItem categoryItem4 = CategoryItem.builder().category(albumCategory).item(album4).build();
        CategoryItem categoryItem5 = CategoryItem.builder().category(albumCategory).item(album5).build();
        CategoryItem categoryItem6 = CategoryItem.builder().category(albumCategory).item(album6).build();
        CategoryItem categoryItem7 = CategoryItem.builder().category(albumCategory).item(album7).build();
        CategoryItem categoryItem8 = CategoryItem.builder().category(albumCategory).item(album8).build();
        CategoryItem categoryItem9 = CategoryItem.builder().category(albumCategory).item(album9).build();
        CategoryItem categoryItem10 = CategoryItem.builder().category(albumCategory).item(album10).build();

        album1.addCategoryItem(categoryItem1);
        album2.addCategoryItem(categoryItem2);
        album3.addCategoryItem(categoryItem3);
        album4.addCategoryItem(categoryItem4);
        album5.addCategoryItem(categoryItem5);
        album6.addCategoryItem(categoryItem6);
        album7.addCategoryItem(categoryItem7);
        album8.addCategoryItem(categoryItem8);
        album9.addCategoryItem(categoryItem9);
        album10.addCategoryItem(categoryItem10);

        albumCategory.addCategoryItem(categoryItem1);
        albumCategory.addCategoryItem(categoryItem2);
        albumCategory.addCategoryItem(categoryItem3);
        albumCategory.addCategoryItem(categoryItem4);
        albumCategory.addCategoryItem(categoryItem5);
        albumCategory.addCategoryItem(categoryItem6);
        albumCategory.addCategoryItem(categoryItem7);
        albumCategory.addCategoryItem(categoryItem8);
        albumCategory.addCategoryItem(categoryItem9);
        albumCategory.addCategoryItem(categoryItem10);

        return List.of(album1,
                album2,
                album3,
                album4,
                album5,
                album6,
                album7,
                album8,
                album9,
                album10);
    }

    private List<Item> bookGenerator(Category bookCategory) {
        Book book1 = Book.builder().author("저자1").isbn("1").price(10000).stockQuantity(50000).name("책1").build();
        Book book2 = Book.builder().author("저자2").isbn("2").price(10000).stockQuantity(50000).name("책2").build();
        Book book3 = Book.builder().author("저자3").isbn("3").price(10000).stockQuantity(50000).name("책3").build();
        Book book4 = Book.builder().author("저자4").isbn("4").price(10000).stockQuantity(50000).name("책4").build();
        Book book5 = Book.builder().author("저자5").isbn("5").price(10000).stockQuantity(50000).name("책5").build();
        Book book6 = Book.builder().author("저자6").isbn("6").price(10000).stockQuantity(50000).name("책6").build();
        Book book7 = Book.builder().author("저자7").isbn("7").price(10000).stockQuantity(50000).name("책7").build();
        Book book8 = Book.builder().author("저자8").isbn("8").price(10000).stockQuantity(50000).name("책8").build();
        Book book9 = Book.builder().author("저자9").isbn("9").price(10000).stockQuantity(50000).name("책9").build();
        Book book10 = Book.builder().author("저자10").isbn("10").price(10000).stockQuantity(50000).name("책10").build();

        CategoryItem categoryItem1 = CategoryItem.builder().category(bookCategory).item(book1).build();
        CategoryItem categoryItem2 = CategoryItem.builder().category(bookCategory).item(book2).build();
        CategoryItem categoryItem3 = CategoryItem.builder().category(bookCategory).item(book3).build();
        CategoryItem categoryItem4 = CategoryItem.builder().category(bookCategory).item(book4).build();
        CategoryItem categoryItem5 = CategoryItem.builder().category(bookCategory).item(book5).build();
        CategoryItem categoryItem6 = CategoryItem.builder().category(bookCategory).item(book6).build();
        CategoryItem categoryItem7 = CategoryItem.builder().category(bookCategory).item(book7).build();
        CategoryItem categoryItem8 = CategoryItem.builder().category(bookCategory).item(book8).build();
        CategoryItem categoryItem9 = CategoryItem.builder().category(bookCategory).item(book9).build();
        CategoryItem categoryItem10 = CategoryItem.builder().category(bookCategory).item(book10).build();

        book1.addCategoryItem(categoryItem1);
        book2.addCategoryItem(categoryItem2);
        book3.addCategoryItem(categoryItem3);
        book4.addCategoryItem(categoryItem4);
        book5.addCategoryItem(categoryItem5);
        book6.addCategoryItem(categoryItem6);
        book7.addCategoryItem(categoryItem7);
        book8.addCategoryItem(categoryItem8);
        book9.addCategoryItem(categoryItem9);
        book10.addCategoryItem(categoryItem10);

        return List.of(book1,
                book2,
                book3,
                book4,
                book5,
                book6,
                book7,
                book8,
                book9,
                book10);
    }

    private List<Item> movieGenerator(Category movieCategory) {
        Movie movie1 = Movie.builder().distributor("제작사1").director("감독1").price(10000).stockQuantity(50000).name("영화1").build();
        Movie movie2 = Movie.builder().distributor("제작사2").director("감독2").price(10000).stockQuantity(50000).name("영화2").build();
        Movie movie3 = Movie.builder().distributor("제작사3").director("감독3").price(10000).stockQuantity(50000).name("영화3").build();
        Movie movie4 = Movie.builder().distributor("제작사4").director("감독4").price(10000).stockQuantity(50000).name("영화4").build();
        Movie movie5 = Movie.builder().distributor("제작사5").director("감독5").price(10000).stockQuantity(50000).name("영화5").build();
        Movie movie6 = Movie.builder().distributor("제작사6").director("감독6").price(10000).stockQuantity(50000).name("영화6").build();
        Movie movie7 = Movie.builder().distributor("제작사7").director("감독7").price(10000).stockQuantity(50000).name("영화7").build();
        Movie movie8 = Movie.builder().distributor("제작사8").director("감독8").price(10000).stockQuantity(50000).name("영화8").build();
        Movie movie9 = Movie.builder().distributor("제작사9").director("감독9").price(10000).stockQuantity(50000).name("영화9").build();
        Movie movie10 = Movie.builder().distributor("제작사10").director("감독10").price(10000).stockQuantity(50000).name("영화10").build();

        CategoryItem categoryItem1 = CategoryItem.builder().category(movieCategory).item(movie1).build();
        CategoryItem categoryItem2 = CategoryItem.builder().category(movieCategory).item(movie2).build();
        CategoryItem categoryItem3 = CategoryItem.builder().category(movieCategory).item(movie3).build();
        CategoryItem categoryItem4 = CategoryItem.builder().category(movieCategory).item(movie4).build();
        CategoryItem categoryItem5 = CategoryItem.builder().category(movieCategory).item(movie5).build();
        CategoryItem categoryItem6 = CategoryItem.builder().category(movieCategory).item(movie6).build();
        CategoryItem categoryItem7 = CategoryItem.builder().category(movieCategory).item(movie7).build();
        CategoryItem categoryItem8 = CategoryItem.builder().category(movieCategory).item(movie8).build();
        CategoryItem categoryItem9 = CategoryItem.builder().category(movieCategory).item(movie9).build();
        CategoryItem categoryItem10 = CategoryItem.builder().category(movieCategory).item(movie10).build();

        movie1.addCategoryItem(categoryItem1);
        movie2.addCategoryItem(categoryItem2);
        movie3.addCategoryItem(categoryItem3);
        movie4.addCategoryItem(categoryItem4);
        movie5.addCategoryItem(categoryItem5);
        movie6.addCategoryItem(categoryItem6);
        movie7.addCategoryItem(categoryItem7);
        movie8.addCategoryItem(categoryItem8);
        movie9.addCategoryItem(categoryItem9);
        movie10.addCategoryItem(categoryItem10);

        return List.of(movie1,
                movie2,
                movie3,
                movie4,
                movie5,
                movie6,
                movie7,
                movie8,
                movie9,
                movie10);
    }
}
