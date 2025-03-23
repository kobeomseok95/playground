package com.example.sse.notification.infrastructure.memory

import com.example.sse.notification.application.NotificationService
import com.example.sse.notification.infrastructure.ChannelRepository
import com.example.sse.notification.model.Notification
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import mu.KotlinLogging
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class InMemoryChannelRepository : ChannelRepository {
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
        channelMap[notification.userId]
            ?.let { channel ->
                channel
                    .trySend(notification.message)
                    .onFailure { error ->
                        logger.warn("⚠️ [InMemory] Failed to send to userId error:${error?.message}")
                    }
            } ?: logger.warn("⚠️ [InMemory] No active channel for user ${notification.userId}")
    }

    override fun unsubscribe(userId: String) {
        logger.info("🧹 Channel removed for user $userId")
        channelMap.remove(userId)
    }
}
