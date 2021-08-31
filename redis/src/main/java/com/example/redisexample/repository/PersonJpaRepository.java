package com.example.redisexample.repository;

import com.example.redisexample.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {
}
