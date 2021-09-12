package com.example.manyimplements.example.service;

import com.example.manyimplements.example.dto.DtoOne;
import com.example.manyimplements.example.dto.DtoTwo;
import com.example.manyimplements.example.entity.EntityMapper;
import com.example.manyimplements.example.entity.EntityOne;
import com.example.manyimplements.example.entity.EntityTwo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapperServiceImpl implements MapperService{

    private final EntityMapper<DtoOne, EntityOne> oneMapper;
    private final EntityMapper<DtoTwo, EntityTwo> twoMapper;

    @Override
    public EntityOne mapOne(DtoOne dtoOne) {
        return oneMapper.mapEntity(dtoOne);
    }

    @Override
    public EntityTwo mapTwo(DtoTwo dtoTwo) {
        return twoMapper.mapEntity(dtoTwo);
    }
}
