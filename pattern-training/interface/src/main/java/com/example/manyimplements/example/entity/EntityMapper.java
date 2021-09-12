package com.example.manyimplements.example.entity;

public interface EntityMapper<D, E> {

    E mapEntity(D dto);
}
