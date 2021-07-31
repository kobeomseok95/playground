package com.demo.querydslexample.repository;

import com.demo.querydslexample.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamJpaRepository extends JpaRepository<Team, Long> {
}
