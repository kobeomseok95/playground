package com.example.asyncevents.booking

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "booking_items")
class BookingItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val bookingId: Long,
    val productItemId: Long,
    val quantity: Int,
) {
    companion object {
        fun of(request: BookingRequest.Item, bookingId: Long): BookingItem = with(request) {
            BookingItem(
                bookingId = bookingId,
                productItemId = productItemId,
                quantity = quantity,
            )
        }
    }
}
