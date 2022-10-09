package com.concurrency.stock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StockConcurrencyApplication

fun main(args: Array<String>) {
    runApplication<StockConcurrencyApplication>(*args)
}
