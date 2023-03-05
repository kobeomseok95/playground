package com.test.unit.domain.classical

import com.test.unit.domain.Customer
import com.test.unit.domain.Product
import com.test.unit.domain.Store
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StoreTest {
    @Test
    fun `재고가 충분할 경우 구매에 성공한다`() {
        // arrange
        val store = Store()
        store.addInventory(Product.SHAMPOO, 10)
        val customer = Customer()

        // act
        val result = customer.purchase(store, Product.SHAMPOO, 5)

        // assert
        assertTrue(result)
        assertEquals(5, store.getInventory(Product.SHAMPOO))
    }

    @Test
    fun `재고가 충분하지 않을 경우 구매에 실패한다`() {
        // arrange
        val store = Store()
        store.addInventory(Product.SHAMPOO, 10)
        val customer = Customer()

        // act
        val result = customer.purchase(store, Product.SHAMPOO, 12)

        // assert
        assertFalse(result)
        assertEquals(10, store.getInventory(Product.SHAMPOO))
    }
}
