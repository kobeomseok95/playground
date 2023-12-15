package com.example.kotlinfixture.domain

import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.util.UUID

data class Booking(
    val id: UUID,
    val externalBookingId: String,
    val user: BookingUser,
    val dateOfUse: LocalDate,
    val status: BookingStatus,
) {
    fun changeStatus(status: BookingStatus): Booking {
        if (status !in nextStatusMap[this.status]!!) {
            throw IllegalArgumentException(
                "예약을 변경할 수 없습니다. id = $id, 현재 상태 : ${this.status}, 요청 상태 : $status"
            )
        }
        return this.copy(
            status = status,
        )
    }

    data class BookingUser(
        val id: String,
        val nickname: String,
    )

    enum class BookingStatus {
        CREATED,
        REJECTED,
        CONFIRMED,
        CANCELED,
    }

    companion object {
        private val nextStatusMap = mapOf(
            BookingStatus.CREATED to setOf(BookingStatus.REJECTED, BookingStatus.CONFIRMED),
            BookingStatus.REJECTED to setOf(),
            BookingStatus.CONFIRMED to setOf(BookingStatus.CANCELED),
            BookingStatus.CANCELED to setOf(),
        )
    }
}
