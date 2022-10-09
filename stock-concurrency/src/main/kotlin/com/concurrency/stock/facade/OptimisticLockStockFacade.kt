package com.concurrency.stock.facade

import com.concurrency.stock.service.PessimisticLockStockService
import org.springframework.stereotype.Service

@Service
class OptimisticLockStockFacade(
    private val optimisticLockStockService: PessimisticLockStockService,
) {

    fun decrease(id: Long, quantity: Long) {
        while(true) {
            try {
                optimisticLockStockService.decrease(id, quantity)
                break
            } catch (e: Exception) {
                Thread.sleep(50)
            }
        }
    }
}