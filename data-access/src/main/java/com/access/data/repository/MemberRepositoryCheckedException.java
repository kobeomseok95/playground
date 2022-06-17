package com.access.data.repository;

import com.access.data.domain.Member;

import java.sql.SQLException;

public interface MemberRepositoryCheckedException {
    Member save(Member member) throws SQLException;
    Member findById(String memberId) throws SQLException;
    // 체크 예외가 인터페이스에서 throw 해야한다는 단점
    void update(String memberId, int money) throws SQLException;
    void delete(String memberId) throws SQLException;
}
