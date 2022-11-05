package com.concurrency.stock.repository

import org.springframework.cache.interceptor.SimpleKeyGenerator.generateKey
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.time.Duration

@Repository
class RedisLockRepository(
    private val redisTemplate: RedisTemplate<String, String>,
) {

    fun lock(key: Long): Boolean = redisTemplate
        .opsForValue()
        .setIfAbsent(generateKey(key), "lock", Duration.ofMillis(3_000L))!!

    private fun generateKey(key: Long): String = key.toString()

    fun unlock(key: Long): Boolean = redisTemplate.delete(generateKey(key))
}
