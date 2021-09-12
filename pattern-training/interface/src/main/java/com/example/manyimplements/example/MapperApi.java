package com.example.manyimplements.example;

import com.example.manyimplements.example.dto.DtoOne;
import com.example.manyimplements.example.dto.DtoTwo;
import com.example.manyimplements.example.entity.EntityOne;
import com.example.manyimplements.example.entity.EntityTwo;
import com.example.manyimplements.example.service.MapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MapperApi {

    private final MapperService mapperService;

    @PostMapping("/map/one")
    public EntityOne mapOne(@RequestBody DtoOne dtoOne) {
        return mapperService.mapOne(dtoOne);
    }

    @PostMapping("/map/two")
    public EntityTwo mapTwo(@RequestBody DtoTwo dtoTwo) {
        return mapperService.mapTwo(dtoTwo);
    }
}
