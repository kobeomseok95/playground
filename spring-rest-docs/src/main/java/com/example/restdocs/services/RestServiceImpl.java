package com.example.restdocs.services;

import com.example.restdocs.dto.GetResponse;
import com.example.restdocs.dto.PostRequest;
import com.example.restdocs.dto.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestServiceImpl implements RestService{

    @Override
    public List<GetResponse> get(Long id) {
        return GetResponse.getResponseList();
    }

    @Override
    public PostResponse post(PostRequest request) {
        if (request.getAge() == 0) {
            return PostResponse.fail();
        }
        return PostResponse.success();
    }
}
