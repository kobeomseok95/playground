package com.example.factorymethod.service;

import com.example.factorymethod.BeanType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IntroServiceFactory {

    private final List<IntroService> introServiceList;

    public String introProcess(BeanType type) {
        IntroService introService = getLectureService(type);
        return introService.introProcess();
    }

    private IntroService getLectureService(BeanType beanType) {
        for (IntroService service : introServiceList) {
            if (service.getBeanType().equals(beanType)) {
                return service;
            }
        }
        return null;
    }
}
