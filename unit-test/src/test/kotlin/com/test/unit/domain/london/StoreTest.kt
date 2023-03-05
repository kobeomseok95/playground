package com.test.unit.domain.london

import com.test.unit.domain.Customer
import com.test.unit.domain.Product
import com.test.unit.domain.Store
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * ??!
 */
internal class StoreTest {
    @Test
    fun `재고가 충분할 경우 구매에 성공한다`() {
        // arrange
        val store = mockk<Store>(relaxed = true)
        every { store.hasEnoughInventory(any(), any()) } returns true
        val customer = Customer()

        // act
        val result = customer.purchase(store, Product.SHAMPOO, 5)

        // assert
        assertTrue(result)
        verify { store.removeInventory(Product.SHAMPOO, 5) }
    }

    @Test
    fun `재고가 충분하지 않을 경우 구매에 실패한다`() {
        // arrange
        val store = mockk<Store>(relaxed = true)
        every { store.hasEnoughInventory(any(), any()) } returns false
        val customer = Customer()

        // act
        val result = customer.purchase(store, Product.SHAMPOO, 5)

        // assert
        assertFalse(result)
        verify(exactly = 0) { store.removeInventory(Product.SHAMPOO, 5) }
    }
}
