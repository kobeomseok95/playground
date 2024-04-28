package com.example.asyncevents.booking.notification

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "booking_notifications")
class BookingNotification(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val bookingId: Long,
    val message: String,
) {
    companion object {
        fun of(
            bookingId: Long,
            message: String,
        ): BookingNotification = BookingNotification(
            bookingId = bookingId,
            message = message,
        )
    }
}
