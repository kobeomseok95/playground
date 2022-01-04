package com.example.solid.unit.modules.member.repository;

import com.example.solid.common.MemberFactory;
import com.example.solid.modules.member.domain.Member;
import com.example.solid.modules.member.repository.MemberJpaRepository;
import com.example.solid.unit.config.TestQuerydslConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Import(TestQuerydslConfiguration.class)
class MemberRepositoryTest {

    @Autowired EntityManager entityManager;
    @Autowired MemberJpaRepository memberJpaRepository;
//    @Autowired MemberFindQuery memberFindQuery;

    @Test
    @DisplayName("이미 존재하는 회원인지 확인한다.")
    void exists_by_phone_test() throws Exception {

        // given
        String phone = "010-1234-1234";
        Member member = MemberFactory.member(phone);
        memberJpaRepository.save(member);
        flushAndClear();

        // when, then
        assertTrue(memberJpaRepository.existsByPhone(phone));
    }

    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }
}
