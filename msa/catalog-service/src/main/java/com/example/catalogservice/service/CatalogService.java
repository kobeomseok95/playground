package com.example.catalogservice.service;

import com.example.catalogservice.repository.CatalogEntity;

public interface CatalogService {

    Iterable<CatalogEntity> getAllCatalogs();
}
