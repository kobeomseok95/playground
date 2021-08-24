package com.example.factorymethod.service.implement;

import com.example.factorymethod.BeanType;
import com.example.factorymethod.service.IntroService;
import org.springframework.stereotype.Service;

@Service
public class UpdateIntroServiceImpl implements IntroService {

    private final BeanType beanType = BeanType.UPDATE;

    @Override
    public String introProcess() {
        return "UPDATE!!!";
    }

    @Override
    public BeanType getBeanType() {
        return this.beanType;
    }
}
