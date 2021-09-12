package com.example.manyimplements.example.object;

import com.example.manyimplements.example.behavior.AnimalCoreBehavior;
import com.example.manyimplements.example.behavior.MarriedMankind;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarriedMan implements MarriedMankind, MarryManService {

    private final AnimalCoreBehavior animalCoreBehavior;

    @Override
    public void greeting() {
        animalCoreBehavior.greeting();
    }

    @Override
    public String getName() {
        return animalCoreBehavior.getName();
    }

    @Override
    public int getAge() {
        return animalCoreBehavior.getAge();
    }

    @Override
    public void crawl() {
        System.out.println("기어 감");
    }

    @Override
    public void married() {
        System.out.println("결혼 하기");
    }

    @Override
    public void walk() {
        System.out.println("걷기");
    }

    @Override
    public String marry() {
        String name = this.getName();
        int age = this.getAge();
        this.greeting();
        System.out.println("나이  = " + age + ", 이름 : " + name);
        this.crawl();
        this.walk();
        this.married();
        return "결혼 완료";
    }
}
