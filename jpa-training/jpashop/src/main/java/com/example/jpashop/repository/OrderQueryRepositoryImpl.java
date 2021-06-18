package com.example.jpashop.repository;

import com.example.jpashop.domain.*;
import com.example.jpashop.domain.item.QItem;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.example.jpashop.domain.QDelivery.*;
import static com.example.jpashop.domain.QMember.*;
import static com.example.jpashop.domain.QOrder.*;
import static com.example.jpashop.domain.QOrderItem.*;
import static com.example.jpashop.domain.item.QItem.*;

@RequiredArgsConstructor
public class OrderQueryRepositoryImpl implements OrderQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Order> findIdFetch(Long orderId) {

        return Optional.ofNullable(
                queryFactory
                        .selectFrom(order).distinct()
                        .join(order.orderItems, orderItem).fetchJoin()
                        .join(order.delivery, delivery).fetchJoin()
                        .join(orderItem.item, item).fetchJoin()
                        .where(order.id.eq(orderId))
                        .fetchOne());
    }

    @Override
    public List<Order> findByMemberIdFetch(Long memberId) {

        return queryFactory
                .selectFrom(order)
                .join(order.member, member).fetchJoin()
                .join(order.delivery, delivery).fetchJoin()
                .join(order.orderItems, orderItem).fetchJoin()
                .join(orderItem.item, item).fetchJoin()
                .where(member.id.eq(memberId))
                .orderBy(order.createdAt.desc())
                .fetch();
    }
}
