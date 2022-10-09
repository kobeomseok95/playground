package com.concurrency.stock.facade

import com.concurrency.stock.domain.Stock
import com.concurrency.stock.repository.StockRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import java.lang.RuntimeException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

@SpringBootTest
internal class NamedLockStockFacadeTest @Autowired constructor(
    private val stockRepository: StockRepository,
    private val stockFacade: NamedLockStockFacade,
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
    fun `동시에 100번 요청한다`() {
        val threadCount = 100
        val executor = Executors.newFixedThreadPool(32)
        val latch = CountDownLatch(threadCount)

        (0 until threadCount).forEach {
            executor.submit {
                try {
                    stockFacade.decrease(1L, 1L)
                } catch(e: InterruptedException) {
                    throw RuntimeException(e)
                } finally {
                    latch.countDown()
                }
            }
        }

        latch.await()

        val stock = stockRepository.findByIdOrNull(1L)

        assertEquals(0L, stock?.quantity)
    }
}