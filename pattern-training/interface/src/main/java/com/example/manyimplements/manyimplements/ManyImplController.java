package com.example.manyimplements.manyimplements;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManyImplController {

//    private final One one;
//    private final Two two;
    private final Three three;

    @GetMapping("/api/one")
    public String getOne() {
        return three.getOne();
    }

    @GetMapping("/api/two")
    public String getTwo() {
        return three.getTwo();
    }

    @GetMapping("/api/three")
    public String getThree() {
        return three.getThree();
    }
}
