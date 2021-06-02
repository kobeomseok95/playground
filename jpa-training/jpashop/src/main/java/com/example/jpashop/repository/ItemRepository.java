package com.example.jpashop.repository;

import com.example.jpashop.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i join fetch CategoryItem ci where i.id = :itemId")
    Optional<Item> findByIdFetch(@Param("itemId") Long id);
}
