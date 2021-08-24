package com.example.factorymethod.service.implement;

import com.example.factorymethod.BeanType;
import com.example.factorymethod.service.IntroService;
import org.springframework.stereotype.Service;

@Service
public class CreateIntroServiceImpl implements IntroService {

    private final BeanType beanType = BeanType.CREATE;

    @Override
    public String introProcess() {
        return "CREATE!!";
    }

    @Override
    public BeanType getBeanType() {
        return this.beanType;
    }
}
