package com.spring.events.service

import com.spring.events.domain.Member
import com.spring.events.domain.RegisterMember
import com.spring.events.domain.RegisterMemberEvent
import com.spring.events.infrastructure.MemberRepository
import com.spring.events.utils.PrintUtils.printWithThread
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberRegisterService(
    private val memberRepository: MemberRepository,
    private val publisher: ApplicationEventPublisher,
) {
    fun register(request: RegisterMember) {
        memberRepository.save(Member.register(request))
            .apply(::publishEvent)
    }

    private fun publishEvent(member: Member) {
        printWithThread("publishEvent()")
        (1..10).forEach {
            publisher.publishEvent(RegisterMemberEvent(memberId = member.requiredId))
        }.also {
            println("호출 완료")
        }
    }
}
