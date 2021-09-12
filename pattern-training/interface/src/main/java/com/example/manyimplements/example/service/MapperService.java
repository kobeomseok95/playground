package com.example.manyimplements.example.service;

import com.example.manyimplements.example.dto.DtoOne;
import com.example.manyimplements.example.dto.DtoTwo;
import com.example.manyimplements.example.entity.EntityOne;
import com.example.manyimplements.example.entity.EntityTwo;

public interface MapperService {

    EntityOne mapOne(DtoOne dtoOne);

    EntityTwo mapTwo(DtoTwo dtoTwo);
}
