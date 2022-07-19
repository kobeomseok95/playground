package com.example.ddd.member.query;

import com.example.ddd.member.command.domain.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberDataJpaRepository extends Repository<Member, Long> {

    @Query(
            "select new com.example.ddd.member.query.MemberData(m.id, m.memberName) " +
            "from Member m " +
            "where m.id = :id"
    )
    Optional<MemberData> findMemberDataById(@Param("id") Long memberId);
}
