package com.example.sse.notification.api

import com.example.sse.notification.model.Notification

data class SendNotificationRequest(
    val userId: String,
    val message: String,
) {
    fun toNotification(): Notification {
        return Notification(userId, message)
    }
}
