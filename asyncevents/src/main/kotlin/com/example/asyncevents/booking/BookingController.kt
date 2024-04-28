package com.example.asyncevents.booking

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bookings")
class BookingController(private val bookingService: BookingService) {
    @PostMapping
    fun book(@RequestBody request: BookingRequest): ResponseEntity<Long> {
        return bookingService.book(request).let { ResponseEntity.ok(it) }
    }
}
