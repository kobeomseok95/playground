package com.example.sse.notification.infrastructure

import com.example.sse.notification.model.Notification
import kotlinx.coroutines.flow.Flow

interface ChannelRepository {
    fun subscribe(userId: String): Flow<String>
    suspend fun send(notification: Notification)
    fun unsubscribe(userId: String)
}
