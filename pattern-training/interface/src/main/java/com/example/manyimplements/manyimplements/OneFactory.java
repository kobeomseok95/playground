package com.example.manyimplements.manyimplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OneFactory {

    private final List<One> oneList;

    public One getOne(GetType type) {
        return oneList.stream()
                .filter(one -> one.getType().equals(type))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("존재하지 않는 타입입니다."));
    }
}
