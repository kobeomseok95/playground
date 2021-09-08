package com.example.manyimplements.manyimplements;

import org.springframework.stereotype.Service;

@Service
public class OneThreeImpl implements One, Three {

    @Override
    public GetType getType() {
        return GetType.ONETHREE;
    }

    @Override
    public String getOne() {
        return "ONETHREE - ONE";
    }

    @Override
    public String getThree() {
        return "ONETHREE - THREE";
    }
}
