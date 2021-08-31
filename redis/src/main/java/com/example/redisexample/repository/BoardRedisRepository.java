package com.example.redisexample.repository;

import com.example.redisexample.vo.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRedisRepository extends CrudRepository<Board, String> {
}
