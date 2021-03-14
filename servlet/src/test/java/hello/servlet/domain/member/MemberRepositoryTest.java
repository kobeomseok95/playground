package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach()
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
//        given
        Member member = Member.builder().username("ko").age(27).build();

//        whenthen
        Member savedMember = memberRepository.save(member);

//        then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {

//        given
        Member member1 = Member.builder().username("ko1").age(27).build();
        Member member2 = Member.builder().username("ko2").age(27).build();
        memberRepository.save(member1);
        memberRepository.save(member2);

//        when
        List<Member> result = memberRepository.findAll();

//        then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}