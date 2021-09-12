package com.example.manyimplements.example.behavior;

import org.springframework.stereotype.Service;

@Service
public class AnimalCoreBehaviorImpl implements AnimalCoreBehavior{

    @Override
    public void greeting() {
        System.out.println("인사한다.");
    }

    @Override
    public String getName() {
        return "내이름";
    }

    @Override
    public int getAge() {
        return 27;
    }
}
