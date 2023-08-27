package com.spring.events.api

import com.spring.events.domain.RegisterMember
import com.spring.events.service.MemberRegisterService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberRegisterController(
    private val memberRegisterService: MemberRegisterService,
) {

    @PostMapping("/members")
    fun registerMember(@RequestBody request: RegisterMember) {
        memberRegisterService.register(request)
    }
}