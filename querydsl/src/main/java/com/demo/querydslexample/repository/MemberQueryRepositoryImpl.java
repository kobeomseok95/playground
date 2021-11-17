package com.demo.querydslexample.repository;

import com.demo.querydslexample.controller.dto.MemberInfo;
import com.demo.querydslexample.controller.dto.QMemberInfo;
import com.demo.querydslexample.controller.dto.QMemberInfo_AddressInfo;
import com.demo.querydslexample.controller.dto.QMemberInfo_ArticleInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.demo.querydslexample.entity.QAddress.address;
import static com.demo.querydslexample.entity.QArticle.article;
import static com.demo.querydslexample.entity.QMember.member;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.set;
import static java.util.stream.Collectors.toList;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepositoryImpl implements MemberQueryRepository{

    private final JPAQueryFactory query;

    @Override
    public List<MemberInfo> getMembersInfo() {
        Map<Long, MemberInfo> resultMap = query
                .from(member)
                .join(address).on(address.member.id.eq(member.id))
                .join(article).on(article.member.id.eq(member.id))
                .transform(groupBy(member.id).as(new QMemberInfo(
                        member.username,
                        set(new QMemberInfo_AddressInfo(address.fullAddress)),
                        set(new QMemberInfo_ArticleInfo(article.title))
                )));

        return resultMap.keySet().stream()
                .map(resultMap::get)
                .collect(toList());
    }
}
