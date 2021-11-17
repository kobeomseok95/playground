package com.demo.querydslexample.repository;

import com.demo.querydslexample.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryRepository {
}
