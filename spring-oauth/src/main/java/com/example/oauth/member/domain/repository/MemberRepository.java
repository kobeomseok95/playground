package com.example.oauth.member.domain.repository;

import com.example.oauth.member.domain.AuthProvider;
import com.example.oauth.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmailAndSocial(String email, boolean social);
    Optional<Member> findByEmailAndAuthProvider(String email, AuthProvider authProvider);
    Optional<Member> findByEmail(String email);
}
