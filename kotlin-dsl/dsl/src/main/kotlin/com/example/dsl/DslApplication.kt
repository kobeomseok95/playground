package com.example.dsl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DslApplication

fun main(args: Array<String>) {
    runApplication<DslApplication>(*args)
}
