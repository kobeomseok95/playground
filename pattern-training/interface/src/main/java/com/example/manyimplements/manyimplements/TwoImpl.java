package com.example.manyimplements.manyimplements;

import org.springframework.stereotype.Service;

@Service
public class TwoImpl implements Two{
    @Override
    public String getOne() {
        return "TWO - ONE";
    }

    @Override
    public String getTwo() {
        return "TWO";
    }
}
