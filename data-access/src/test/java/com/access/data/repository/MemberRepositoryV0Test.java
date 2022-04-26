package com.access.data.repository;

import com.access.data.domain.Member;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryV0Test {

    MemberRepositoryV0 memberRepository = new MemberRepositoryV0();

    @Test
    void save() throws SQLException {
        Member member = new Member("memberV0", 10_000);
        memberRepository.save(member);
    }
}