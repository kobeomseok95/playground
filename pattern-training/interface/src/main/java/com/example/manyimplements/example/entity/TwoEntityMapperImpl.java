package com.example.manyimplements.example.entity;

import com.example.manyimplements.example.dto.DtoTwo;
import org.springframework.stereotype.Service;

@Service
public class TwoEntityMapperImpl implements EntityMapper<DtoTwo, EntityTwo>{

    @Override
    public EntityTwo mapEntity(DtoTwo dto) {
        return EntityTwo.builder()
                .name(dto.getName())
                .build();
    }
}
