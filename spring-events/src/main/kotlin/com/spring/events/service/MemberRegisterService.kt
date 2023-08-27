package com.spring.events.service

import com.spring.events.domain.Member
import com.spring.events.domain.RegisterMember
import com.spring.events.domain.RegisterMemberEvent
import com.spring.events.infrastructure.MemberRepository
import mu.KotlinLogging
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

private val logger = KotlinLogging.logger {}

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
        logger.info { "publishEvent() / transaction name = ${TransactionSynchronizationManager.getCurrentTransactionName()}" }
        publisher.publishEvent(RegisterMemberEvent(memberId = member.requiredId))
    }
}
