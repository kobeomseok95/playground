package com.example.jpashop.repository;

import com.example.jpashop.domain.item.Item;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemQueryRepository {

    Optional<Item> findByIdFetch(Long id);
}
