package com.example.restdocs.services;

import com.example.restdocs.dto.GetResponse;
import com.example.restdocs.dto.PostRequest;
import com.example.restdocs.dto.PostResponse;

import java.util.List;

public interface RestService {

    List<GetResponse> get(Long id);

    PostResponse post(PostRequest request);
}
