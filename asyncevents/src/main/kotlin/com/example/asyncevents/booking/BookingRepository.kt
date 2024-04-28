package com.example.asyncevents.booking

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface BookingJpaRepository : JpaRepository<Booking, Long>

interface BookingItemJpaRepository : JpaRepository<BookingItem, Long>

@Repository
class BookingRepository(
    private val bookingJpaRepository: BookingJpaRepository,
    private val bookingItemJpaRepository: BookingItemJpaRepository,
) {
    fun saveBooking(booking: Booking): Booking {
        return bookingJpaRepository.save(booking)
    }

    fun saveBookingItems(bookingItems: List<BookingItem>): List<BookingItem> {
        return bookingItemJpaRepository.saveAll(bookingItems)
    }
}
