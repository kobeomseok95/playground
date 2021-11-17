package com.demo.querydslexample.repository;

import com.demo.querydslexample.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
