package com.example.kotlinfixture.domain

import com.appmattus.kotlinfixture.kotlinFixture
import io.kotest.core.spec.style.StringSpec
import java.lang.RuntimeException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

class BookingTest : StringSpec({
    val fixture = kotlinFixture()

    "예약 상태 - CREATED -> CONFIRMED" {
        val booking = fixture<Booking> {
            property(Booking::status) { Booking.BookingStatus.CREATED }
        }

        val result = booking.changeStatus(Booking.BookingStatus.CONFIRMED)

        assertEquals(Booking.BookingStatus.CONFIRMED, result.status)
    }

    "예약 상태 - CREATED -> REJECTED" {
        val booking = fixture<Booking> {
            property(Booking::status) { Booking.BookingStatus.CREATED }
        }

        val result = booking.changeStatus(Booking.BookingStatus.REJECTED)

        assertEquals(Booking.BookingStatus.REJECTED, result.status)
    }

    "예약 상태 - CREATED -X-> CANCELED" {
        val booking = fixture<Booking> {
            property(Booking::status) { Booking.BookingStatus.CREATED }
        }

        assertThrows<RuntimeException> {
            booking.changeStatus(Booking.BookingStatus.CANCELED)
        }
    }
})
