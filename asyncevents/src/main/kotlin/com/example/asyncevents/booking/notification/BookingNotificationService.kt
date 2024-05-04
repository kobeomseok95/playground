package com.example.asyncevents.booking.notification

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookingNotificationService(
    private val bookingNotificationRepository: BookingNotificationRepository,
) {
    @Async
    @Transactional
    fun notify(bookingId: Long) {
        val formattedMessage = String.format(MESSAGE, bookingId)
        BookingNotification.of(bookingId, formattedMessage).apply {
            bookingNotificationRepository.save(this)
        }
        logger.info(formattedMessage)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(BookingNotificationService::class.java)
        private const val MESSAGE = "========== %s 예약 완료 ==========="
    }
}
