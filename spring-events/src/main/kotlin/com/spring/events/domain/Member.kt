package com.spring.events.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.domain.AbstractAggregateRoot

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var age: Int,
) : AbstractAggregateRoot<Member>() {
    val requiredId: Long
        get() = requireNotNull(id) { "not persisted !" }

    val firstIssueCouponName: String
        get() = "$name 님의 회원 가입 쿠폰"

    private fun publishEvent(event: RegisterMemberEvent) {
        registerEvent(event)
    }

    companion object {
        fun register(command: RegisterMember) = Member(
            name = command.name,
            age = command.age,
        )
    }
}

data class RegisterMemberEvent(
    val memberId: Long,
)

data class RegisterMember(
    val name: String,
    val age: Int,
)
