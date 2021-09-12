package com.example.manyimplements.example;

import com.example.manyimplements.example.object.MarriedMan;
import com.example.manyimplements.example.object.MarryManService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Api {

    private final MarryManService service;

    @GetMapping("/marry")
    public String marry() {
        return service.marry();
    }
}
