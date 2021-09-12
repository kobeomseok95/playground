package com.example.manyimplements.manyimplements;

import org.springframework.stereotype.Service;

@Service
public class ThreeImpl implements Three{
    @Override
    public String getOne() {
        return "THREE - ONE";
    }

    @Override
    public String getThree() {
        return "THREE";
    }

    @Override
    public String getTwo() {
        return "THREE - TWO";
    }
}
