package com.example.solid.modules.member.application.port.out;

public interface MemberFindQuery {

    boolean existsByPhone(String phone);
}
