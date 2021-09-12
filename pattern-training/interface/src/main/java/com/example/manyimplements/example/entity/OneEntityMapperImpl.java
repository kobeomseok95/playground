package com.example.manyimplements.example.entity;

import com.example.manyimplements.example.dto.DtoOne;
import org.springframework.stereotype.Service;

@Service
public class OneEntityMapperImpl implements EntityMapper<DtoOne, EntityOne>{

    @Override
    public EntityOne mapEntity(DtoOne dto) {
        return EntityOne.builder()
                .name(dto.getName())
                .build();
    }
}
