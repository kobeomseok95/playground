package com.example.jpashop.repository;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.QCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.example.jpashop.domain.QCategory.*;

@RequiredArgsConstructor
public class CategoryQueryRepositoryImpl implements CategoryQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Category> findByParentIdIsNull() {
        return queryFactory.selectDistinct(category)
                .from(category)
                .leftJoin(category.children).fetchJoin()
                .where(category.parent.isNull())
                .fetch();
    }

    @Override
    public Optional<Category> findByIdFetch(Long id) {
        return Optional.ofNullable(queryFactory.selectFrom(category)
                .leftJoin(category.categoryItems).fetchJoin()
                .where(category.id.eq(id))
                .fetchOne());
    }
}
