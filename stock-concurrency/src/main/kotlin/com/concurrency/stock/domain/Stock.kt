package com.concurrency.stock.domain

import java.lang.IllegalArgumentException
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Version

@Entity
class Stock(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val productId: Long,
    var quantity: Long,
    @Version
    var version: Long? = null,
) {

    fun decrease(quantity: Long) {
        checkQuantityIsZeroGoe(quantity)
        this.quantity = this.quantity - quantity
    }

    private fun checkQuantityIsZeroGoe(quantity: Long) {
        if (this.quantity - quantity < 0) {
            throw IllegalArgumentException("재고가 0 미만일 수 없습니다.")
        }
    }
}
