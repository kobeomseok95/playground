package com.example.asyncevents.async

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.CompletableFuture
import kotlin.random.Random

@Service
@Transactional
class GetRandomNumberService {
    fun getRandomNumberSync(): Long {
        return Random.nextLong()
    }

    // @Async
    fun getRandomNumberAsync(): CompletableFuture<Long> {
        return CompletableFuture.supplyAsync {
            Random.nextLong()
        }
    }
}
