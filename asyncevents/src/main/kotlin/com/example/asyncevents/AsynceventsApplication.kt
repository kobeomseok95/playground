package com.example.asyncevents

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class AsynceventsApplication

fun main(args: Array<String>) {
    runApplication<AsynceventsApplication>(*args)
}
