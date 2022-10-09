package com.concurrency.stock.repository

import com.concurrency.stock.domain.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import javax.persistence.LockModeType

interface StockRepository: JpaRepository<Stock, Long> {
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Stock s where s.id = :id")
    fun findByIdWithPessimisticLock(id: Long): Stock

    @Lock(value = LockModeType.OPTIMISTIC)
    @Query("select s from Stock s where s.id = :id")
    fun findByIdWithOptimisticLock(id: Long): Stock
}