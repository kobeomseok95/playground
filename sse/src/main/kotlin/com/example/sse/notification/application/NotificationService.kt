package com.example.sse.notification.application

import com.example.sse.notification.SendNotification
import com.example.sse.notification.SubscribeNotification
import com.example.sse.notification.model.Notification
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class NotificationService(

) : SendNotification, SubscribeNotification {
    private val logger = KotlinLogging.logger { }
    private val channelMap = ConcurrentHashMap<String, Channel<String>>()

    override fun subscribe(userId: String): Flow<String> {
        val channel = channelMap.computeIfAbsent(userId) {
            logger.info("Created new channel for user $userId")
            Channel(capacity = Channel.BUFFERED)
        }

        return channel.receiveAsFlow()
    }

    override suspend fun send(notification: Notification) {
        val channel = channelMap[notification.userId]
        if (channel != null) {
            logger.info("Sending notification to ${notification.userId}: ${notification.message}")

            channel
                .trySend(notification.message)
                .onFailure { logger.warn("Failed to send notification: ${it?.message}") }
        } else {
            logger.warn("No active channel for user ${notification.userId}")
        }
    }
}
