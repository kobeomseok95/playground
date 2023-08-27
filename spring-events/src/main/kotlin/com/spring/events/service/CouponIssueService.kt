package com.spring.events.service

import com.spring.events.domain.Coupon
import com.spring.events.domain.CouponIssueCommand
import com.spring.events.infrastructure.CouponRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CouponIssueService(
    private val couponRepository: CouponRepository,
) {
    fun issue(command: CouponIssueCommand) {
        couponRepository.save(Coupon.of(command))
    }
}
