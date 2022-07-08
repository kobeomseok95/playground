package com.example.ddd.member.command.infrastructure;

import com.example.ddd.member.command.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
