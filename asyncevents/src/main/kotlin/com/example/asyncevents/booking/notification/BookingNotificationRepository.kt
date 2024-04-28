package com.example.asyncevents.booking.notification

import org.springframework.data.jpa.repository.JpaRepository

interface BookingNotificationRepository : JpaRepository<BookingNotification, Long>
