package com.example.sse.notification

import kotlinx.coroutines.flow.Flow

interface SubscribeNotification {
    fun subscribe(userId: String): Flow<String>
}
