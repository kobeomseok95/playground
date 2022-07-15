package com.hello.kotlin

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MessageService(
    val messageRepository : MessageRepository
) {
    fun findMessages(): List<Message> = messageRepository.findAll()

    fun saveMessage(message: Message) {
        messageRepository.save(message);
    }
}