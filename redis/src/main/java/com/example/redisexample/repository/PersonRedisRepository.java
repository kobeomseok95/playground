package com.example.redisexample.repository;

import com.example.redisexample.entity.Person;
import com.example.redisexample.vo.PersonRedis;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<PersonRedis, String> {
}
