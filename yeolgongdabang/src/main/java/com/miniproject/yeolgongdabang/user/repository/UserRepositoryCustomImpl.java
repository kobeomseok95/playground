package com.miniproject.yeolgongdabang.user.repository;

import com.miniproject.yeolgongdabang.user.QUser;
import com.miniproject.yeolgongdabang.user.QUserSeat;
import com.miniproject.yeolgongdabang.user.User;
import com.miniproject.yeolgongdabang.user.UserSeat;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.miniproject.yeolgongdabang.user.QUser.*;
import static com.miniproject.yeolgongdabang.user.QUserSeat.*;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public UserSeat findByPhoneFetchSeatedAndEnableSeat(String phone) {
        return queryFactory
                .selectFrom(userSeat)
                .join(userSeat.user, user).fetchJoin()
                .where(user.phone.eq(phone)
                        .and(userSeat.seated.isTrue()))
                .fetchOne();
    }
}
