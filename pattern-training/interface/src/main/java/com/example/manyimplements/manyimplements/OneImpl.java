package com.example.manyimplements.manyimplements;

import org.springframework.stereotype.Service;

@Service
public class OneImpl implements One{
    @Override
    public String getOne() {
        return "one";
    }
}
