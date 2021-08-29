package com.example.querytraining.repository;

import com.example.querytraining.dto.PostDto;

public interface PostRepository {

    PostDto findPostDto(Long postId);
}
