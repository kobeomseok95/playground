package com.example.jpashop.repository;

import com.example.jpashop.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i join fetch CategoryItem ci where i.id = :itemId")
    Optional<Item> findByIdFetch(@Param("itemId") Long id);

    List<Item> findByIdIn(Collection<Long> itemIds);

    @Modifying(clearAutomatically = true)   // JPQL이기 때문에 clear만 해줘도 된다.
    @Query("update Item i set i.stockQuantity = i.stockQuantity where i.id in :itemIds")
    void updateItemStockQuantity(@Param("itemIds") List<Long> itemIds);
}
