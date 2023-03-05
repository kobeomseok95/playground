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
        quantity: Long,
    ): Boolean {
        if (!hasEnoughInventory(product, quantity)) {
            return false
        }

        inventory[product] = getInventory(product) - quantity
        return true
    }

    fun getInventory(
        product: Product,
    ): Long {
        return requireNotNull(inventory[product]) {
            "상품을 찾을 수 없습니다."
        }
    }

    fun hasEnoughInventory(
        product: Product,
        quantity: Long,
    ): Boolean = getInventory(product) >= quantity
}
