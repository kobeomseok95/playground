package com.test.unit.domain

class Customer(

) {

    fun purchase(
        store: Store,
        product: Product,
        count: Long,
    ): Boolean {
        if (!store.hasEnoughInventory(product, count)) {
            return false
        }
        store.removeInventory(product, count)
        return true
    }
}
