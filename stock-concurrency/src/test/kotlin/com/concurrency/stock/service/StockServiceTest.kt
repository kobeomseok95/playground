package com.concurrency.stock.service

import com.concurrency.stock.domain.Stock
import com.concurrency.stock.repository.StockRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.servlet.function.ServerResponse.async
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

@SpringBootTest
internal class StockServiceTest @Autowired constructor(
    private val stockRepository: StockRepository,
    private val stockService: StockService,
) {

    @BeforeEach
    internal fun setUp() {
        stockRepository.saveAndFlush(
            Stock(productId = 1L, quantity = 100L)
        )
    }

    @AfterEach
    internal fun tearDown() {
        stockRepository.deleteAll()
    }

    @Test
    fun `재고를 감소시킨다`() {
        stockService.decrease(1L, 1L)

        val stock = stockRepository.findByIdOrNull(1L)

        assertEquals(99L, stock?.quantity)
    }
}
