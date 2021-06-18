package com.example.jpashop.repository;

import com.example.jpashop.domain.QCategoryItem;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.QItem;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.example.jpashop.domain.QCategoryItem.*;
import static com.example.jpashop.domain.item.QItem.*;

@RequiredArgsConstructor
public class ItemQueryRepositoryImpl implements ItemQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Item> findByIdFetch(Long id) {
        return Optional.ofNullable(
            queryFactory.selectFrom(item)
                .join(item.categoryItems, categoryItem).fetchJoin()
                .where(item.id.eq(id))
                .fetchOne()
        );
    }
}
