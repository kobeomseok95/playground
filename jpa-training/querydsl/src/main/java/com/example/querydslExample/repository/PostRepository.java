package com.example.querydslExample.repository;

import com.example.querydslExample.dto.PostDto;
import com.example.querydslExample.dto.QPostDto;
import com.example.querydslExample.dto.QPostDto_CommentDto;
import com.example.querydslExample.entity.QComment;
import com.example.querydslExample.entity.QPost;
import com.querydsl.core.group.GroupBy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.querydslExample.entity.QComment.*;
import static com.example.querydslExample.entity.QPost.*;
import static com.querydsl.core.group.GroupBy.groupBy;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final JPAQueryFactory query;

    public PostDto getPost(Long postId) {

        return query.from(post).leftJoin(post.commentList, comment)
                .where(post.id.eq(postId))
                .orderBy(comment.id.asc())
                .transform(groupBy(post.id).as(new QPostDto(
                        post.title,
                        GroupBy.set(new QPostDto_CommentDto(
                                comment.id,
                                comment.text
                        ))
                ))).get(postId);
    }
}
