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
internal class OptimisticLockStockFacadeTest @Autowired constructor(
    private val stockRepository: StockRepository,
    private val stockFacade: OptimisticLockStockFacade,
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
        stockFacade.decrease(1L, 1L)

        val stock = stockRepository.findByIdOrNull(1L)

        assertEquals(99L, stock?.quantity)
    }

    @Test
    fun `동시에 100번 요청한다`() {
        val threadCount = 100
        // TODO: 왜 여기서는 쓰레드 풀의 갯수를 32개로 맞춰야하는가?
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
