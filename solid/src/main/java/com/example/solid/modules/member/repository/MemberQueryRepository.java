package com.example.solid.modules.member.repository;

interface MemberQueryRepository {

    boolean existsByPhone(String phone);
}
