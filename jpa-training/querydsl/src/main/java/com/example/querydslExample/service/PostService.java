package com.example.querydslExample.service;

import com.example.querydslExample.dto.PostDto;
import com.example.querydslExample.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostDto getPost(Long postId) {
        return postRepository.getPost(postId);
    }
}
