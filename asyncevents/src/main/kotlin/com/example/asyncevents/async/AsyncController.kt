package com.example.asyncevents.async

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class AsyncController(
    private val getRandomNumberService: GetRandomNumberService,
) {

    @GetMapping("/sync")
    fun getRandomNumberSync(): ResponseEntity<Long> {
        return getRandomNumberService.getRandomNumberSync()
            .let { ResponseEntity.ok(it) }
    }

    @GetMapping("/async")
    fun getRandomNumberAsync(): ResponseEntity<Long> {
        return getRandomNumberService.getRandomNumberAsync()
            .get()
            .let { ResponseEntity.ok(it) }
    }
}
