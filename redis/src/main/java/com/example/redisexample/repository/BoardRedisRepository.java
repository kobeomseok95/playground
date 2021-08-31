package com.example.redisexample.repository;

import com.example.redisexample.vo.BoardForm;
import org.springframework.data.repository.CrudRepository;

public interface BoardRedisRepository extends CrudRepository<BoardForm, String> {
}
