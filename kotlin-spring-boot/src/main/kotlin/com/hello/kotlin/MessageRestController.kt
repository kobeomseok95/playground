package com.hello.kotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageRestController(
    val messageService : MessageService
) {

    @GetMapping("messages")
    fun getMessages(): List<Message> = messageService.findMessages()

    @PostMapping("messages")
    fun saveMessage(
        @RequestBody
        message : Message
    ) {
        messageService.saveMessage(message)
    }
}