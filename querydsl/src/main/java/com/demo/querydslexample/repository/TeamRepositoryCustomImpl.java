package com.demo.querydslexample.repository;

import com.demo.querydslexample.dto.TeamMembersDto;
import com.demo.querydslexample.entity.QMember;
import com.demo.querydslexample.entity.QTeam;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.demo.querydslexample.entity.QMember.*;
import static com.demo.querydslexample.entity.QTeam.*;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.types.Projections.list;

@Repository
@RequiredArgsConstructor
public class TeamRepositoryCustomImpl implements TeamRepositoryCustom {

    private final JPAQueryFactory query;

    @Override
    public List<TeamMembersDto> search(Long teamId) {
        return query.selectFrom(team)
                .innerJoin(member)
                .on(team.id.eq(member.team.id))
                .where(team.id.eq(teamId))
                .transform(
                        groupBy(team.id).list(
                                Projections.fields(
                                        TeamMembersDto.class,
                                        team.id.as("teamId"),
                                        team.name.as("teamName"),
                                        GroupBy.list(
                                                Projections.fields(
                                                        TeamMembersDto.TeamMember.class,
                                                        member.id.as("memberId"),
                                                        member.username.as("username"),
                                                        member.age
                                                )
                                        ).as("teamMembers")
                                )
                        )
                );
    }
}
