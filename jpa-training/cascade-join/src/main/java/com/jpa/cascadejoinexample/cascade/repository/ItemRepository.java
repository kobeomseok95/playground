package com.jpa.cascadejoinexample.cascade.repository;

import com.jpa.cascadejoinexample.cascade.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
