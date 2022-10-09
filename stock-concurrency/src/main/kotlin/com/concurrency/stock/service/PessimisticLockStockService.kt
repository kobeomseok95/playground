package com.concurrency.stock.service

import com.concurrency.stock.repository.StockRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PessimisticLockStockService(
    private val stockRepository: StockRepository,
) {

    @Transactional
    fun decrease(id: Long, quantity: Long) {
        stockRepository.findByIdWithPessimisticLock(id)
            .decrease(quantity)
    }
}