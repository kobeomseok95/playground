package com.example.sse.notification

import com.example.sse.notification.model.Notification

interface SendNotification {
    suspend fun send(notification: Notification)
}
