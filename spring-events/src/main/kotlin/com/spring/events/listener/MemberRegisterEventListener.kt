package com.spring.events.listener

import com.spring.events.domain.CouponIssueCommand
import com.spring.events.domain.RegisterMemberEvent
import com.spring.events.infrastructure.MemberRepository
import com.spring.events.service.CouponIssueService
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener
import org.springframework.transaction.support.TransactionSynchronizationManager

private val logger = KotlinLogging.logger {}

@Service
class MemberRegisterEventListener(
    private val memberRepository: MemberRepository,
    private val couponIssueService: CouponIssueService,
) {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRED)
    fun issuedCoupon(event: RegisterMemberEvent) {
        logger.info { "issuedCoupon() / transaction name = ${TransactionSynchronizationManager.getCurrentTransactionName()}" }
        memberRepository.findByIdOrNull(event.memberId)
            ?.let {
                couponIssueService.issue(
                    command = CouponIssueCommand(
                        memberId = it.requiredId,
                        name = it.firstIssueCouponName,
                    )
                )
            } ?: throw IllegalArgumentException("not exists member ! memberId = ${event.memberId}")
    }
}
