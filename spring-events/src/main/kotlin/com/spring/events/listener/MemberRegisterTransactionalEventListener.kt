package com.spring.events.listener

import com.spring.events.domain.CouponIssueCommand
import com.spring.events.domain.RegisterMemberEvent
import com.spring.events.infrastructure.MemberRepository
import com.spring.events.service.CouponIssueService
import com.spring.events.utils.PrintUtils.printWithThread
import org.springframework.data.repository.findByIdOrNull
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class MemberRegisterTransactionalEventListener(
    private val memberRepository: MemberRepository,
    private val couponIssueService: CouponIssueService,
) {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    @Transactional(propagation = Propagation.REQUIRED)
    fun issuedCoupon(event: RegisterMemberEvent) {
        printWithThread(event)
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

//@Component
//class MemberRegisterEventListener(
//    private val memberRepository: MemberRepository,
//    private val couponIssueService: CouponIssueService,
//) {
//    @Async
//    @EventListener
//    fun issueCoupon(event: RegisterMemberEvent) {
//        printWithThread(event)
//        memberRepository.findByIdOrNull(event.memberId)
//            ?.let { member ->
//                issueCouponToMember(member)
//            } ?: throw IllegalArgumentException("not exists member ! memberId = ${event.memberId}")
//    }
//
//    private fun issueCouponToMember(member: Member) {
//        couponIssueService.issue(
//            command = CouponIssueCommand(
//                memberId = member.requiredId,
//                name = member.firstIssueCouponName,
//            )
//        )
//    }
//}
