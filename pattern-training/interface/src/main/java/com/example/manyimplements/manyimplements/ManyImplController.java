package com.example.manyimplements.manyimplements;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManyImplController {

    private final OneFactory oneFactory;
    private final Two two;
    private final Three three;

    // ONETWO 타입과 ONETHREE 타입이 존재
    @GetMapping("/api/{type}/one")
    public String getOne(@PathVariable GetType type) {
        return oneFactory.getOne(type).getOne();
    }

    @GetMapping("/api/two")
    public String getTwo() {
        return two.getTwo();
    }

    @GetMapping("/api/three")
    public String getThree() {
        return three.getThree();
    }
}
