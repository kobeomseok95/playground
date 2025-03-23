package com.example.sse.notification.application

import com.example.sse.notification.SendNotification
import com.example.sse.notification.SubscribeNotification
import com.example.sse.notification.infrastructure.ChannelRepository
import com.example.sse.notification.model.Notification
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.timeout
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.time.Duration
import kotlin.time.toKotlinDuration

@Service
class NotificationService(
    private val channelRepository: ChannelRepository,
) : SendNotification, SubscribeNotification {
    private val logger = KotlinLogging.logger { }

    override fun subscribe(userId: String): Flow<String> {
        return channelRepository.subscribe(userId)
            .onEach { logger.info("📩 Sending to $userId: $it") }
            .timeout(TIMEOUT_DURATION)
            .onCompletion {
                logger.info("⏱️ Subscription timeout or closed for $userId")
                unSubscribe(userId)
            }
    }

    override suspend fun send(notification: Notification) {
        channelRepository.send(notification)
    }

    private fun unSubscribe(userId: String) {
        channelRepository.unsubscribe(userId)
    }

    companion object {
        private val TIMEOUT_DURATION = Duration.ofSeconds(10).toKotlinDuration()
    }
}
