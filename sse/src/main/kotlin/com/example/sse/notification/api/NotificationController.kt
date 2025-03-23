package com.example.sse.notification.api

import com.example.sse.notification.SendNotification
import com.example.sse.notification.SubscribeNotification
import kotlinx.coroutines.flow.Flow
import mu.KotlinLogging
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/notifications")
class NotificationController(
    private val sendNotification: SendNotification,
    private val subscribeNotification: SubscribeNotification,
) {
    private val logger = KotlinLogging.logger { }

    @GetMapping(
        "/subscribe/{userId}",
        produces = [MediaType.TEXT_EVENT_STREAM_VALUE],
    )
    fun subscribe(@PathVariable userId: String): Flow<String> {
        logger.info("📡 User $userId subscribed for notifications")
        return subscribeNotification.subscribe(userId)
    }

    @PostMapping("/send")
    suspend fun sendNotification(@RequestBody request: SendNotificationRequest) {
        logger.info("🚀 Sending notification to $request")
        sendNotification.send(request.toNotification())
    }
}
