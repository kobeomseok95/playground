package com.example.querytraining.repository;

import com.example.querytraining.dto.PostDto;
import com.example.querytraining.dto.QPostDto;
import com.example.querytraining.dto.QPostDto_CommentDto;
import com.querydsl.core.group.GroupBy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.querytraining.entity.QCommentEntity.commentEntity;
import static com.example.querytraining.entity.QPostEntity.postEntity;
import static com.querydsl.core.group.GroupBy.groupBy;

@Repository
@RequiredArgsConstructor
public class PostQueryRepositoryImpl implements PostRepository{

    private final JPAQueryFactory query;

    @Override
    public PostDto findPostDto(Long postId) {
        return query.from(postEntity)
                .leftJoin(postEntity.commentEntityList, commentEntity)
                .where(postEntity.id.eq(postId))
                .orderBy(commentEntity.realOrder.asc())
                .transform(groupBy(postEntity.id).as(new QPostDto(
                        postEntity.title,
                        GroupBy.set(new QPostDto_CommentDto(
                                commentEntity.realOrder,
                                commentEntity.text
                        ))
                ))).get(postId);
    }
}
