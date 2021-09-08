package com.example.manyimplements.manyimplements;

import org.springframework.stereotype.Service;

@Service
public class OneTwoImpl implements One, Two {

    @Override
    public GetType getType() {
        return GetType.ONETWO;
    }

    @Override
    public String getOne() {
        return "ONETWO - ONE";
    }

    @Override
    public String getTwo() {
        return "ONETWO - TWO";
    }
}
