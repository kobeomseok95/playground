package com.concurrency.stock.facade

import com.concurrency.stock.repository.RedisLockRepository
import com.concurrency.stock.service.StockService
import org.springframework.stereotype.Component

@Component
class LettuceLockStockFacade(
    private val redisLockRepository: RedisLockRepository,
    private val stockService: StockService,
) {

    fun decrease(key: Long, quantity: Long) {
        while (!redisLockRepository.lock(key)) {
            Thread.sleep(100)
        }

        try {
            stockService.decrease(key, quantity)
        } finally {
            redisLockRepository.unlock(key)
        }
    }
}