package com.example.asyncevents.booking

import com.example.asyncevents.booking.notification.BookingNotificationService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BookingService(
    private val bookingRepository: BookingRepository,
    private val bookingNotificationService: BookingNotificationService,
) {
    fun book(request: BookingRequest): Long {
        val booking = Booking.of(request).apply {
            bookingRepository.saveBooking(this)
        }
        request.items.map { BookingItem.of(it, booking.id!!) }.apply {
            bookingRepository.saveBookingItems(this)
        }
        return booking.id!!.apply {
            bookingNotificationService.notify(this)
        }
    }
}
