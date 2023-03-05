package com.test.unit.domain

class Store(
    private val inventory: MutableMap<Product, Long> = mutableMapOf()
) {

    fun addInventory(
        product: Product,
        count: Long,
    ) {
        inventory[product] = count
    }

    fun removeInventory(
        product: Product,
        count: Long,
    ): Boolean {
        if (getInventory(product) - count < 0) {
            return false
        }

        inventory[product] = getInventory(product) - count
        return true
    }

    fun getInventory(
        product: Product,
    ): Long {
        return requireNotNull(inventory[product]) {
            "상품을 찾을 수 없습니다."
        }
    }
}
