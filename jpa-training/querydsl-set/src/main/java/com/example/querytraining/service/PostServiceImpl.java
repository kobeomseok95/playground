package com.example.querytraining.service;

import com.example.querytraining.dto.PostDto;
import com.example.querytraining.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public PostDto getPost(Long postId) {
        return postRepository.findPostDto(postId);
    }

    @Override
    public void delete() {
        postRepository.delete();
    }
}
