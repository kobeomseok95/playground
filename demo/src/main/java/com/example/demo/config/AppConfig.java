package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * Destination 타입은 꼭 Setter가 존재해야한다.
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE)
                .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE);
        return modelMapper;
    }
}
