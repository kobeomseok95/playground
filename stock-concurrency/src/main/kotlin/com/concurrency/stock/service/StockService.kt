package com.concurrency.stock.service

import com.concurrency.stock.repository.StockRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class StockService(
    private val stockRepository: StockRepository,
) {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun decrease(id: Long, quantity: Long) {
        stockRepository.findByIdOrNull(id)
            ?.decrease(quantity)
    }
}
