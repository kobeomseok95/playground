package com.test.unit.domain

class Customer(

) {

    fun purchase(
        store: Store,
        product: Product,
        count: Long,
    ): Boolean {
        return store.removeInventory(product, count)
    }
}