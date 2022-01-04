package com.example.solid.modules.member.repository;

import com.example.solid.modules.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository
        extends JpaRepository<Member, Long>,
        MemberQueryRepository {
}
