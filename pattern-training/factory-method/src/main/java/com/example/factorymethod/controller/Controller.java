package com.example.factorymethod.controller;

import com.example.factorymethod.BeanType;
import com.example.factorymethod.service.IntroServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final IntroServiceFactory introServiceFactory;

    @GetMapping("/intro/{type}")
    public String intro(@PathVariable String type) {
        BeanType beanType = BeanType.valueOf(type);
        return introServiceFactory.introProcess(beanType);
    }
}
