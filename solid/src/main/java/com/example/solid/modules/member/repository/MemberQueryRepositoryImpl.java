package com.example.solid.modules.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.solid.modules.member.domain.QMember.member;

@Repository
@RequiredArgsConstructor
class MemberQueryRepositoryImpl implements MemberQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public boolean existsByPhone(String phone) {
        Integer fetchOne = queryFactory.selectOne()
                .from(member)
                .where(member.phone.eq(phone))
                .fetchFirst();
        return fetchOne != null;
    }
}
