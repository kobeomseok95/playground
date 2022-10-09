package com.concurrency.stock.repository

import com.concurrency.stock.domain.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface LockRepository: JpaRepository<Stock, Long> {
    // TODO: 별도의 datasource를 사용하자.
    @Query(
        value = "select get_lock(:key, 3000)",
        nativeQuery = true
    )
    fun getLock(key: String)

    @Query(
        value = "select release_lock(:key)",
        nativeQuery = true
    )
    fun releaseLock(key: String)
}