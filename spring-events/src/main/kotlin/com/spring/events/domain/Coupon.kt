package com.spring.events.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
class Coupon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val issuedMemberId: Long,
    val discountPoint: BigDecimal,
    val issuedAt: LocalDateTime,
) {
    companion object {
        fun of(command: CouponIssueCommand) = Coupon(
            issuedMemberId = command.memberId,
            discountPoint = BigDecimal("2000"),
            name = command.name,
            issuedAt = command.issuedAt,
        )
    }
}

data class CouponIssueCommand(
    val memberId: Long,
    val name: String,
    val issuedAt: LocalDateTime = LocalDateTime.now(),
)
