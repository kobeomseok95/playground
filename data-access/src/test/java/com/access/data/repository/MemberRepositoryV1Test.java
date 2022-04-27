package com.access.data.repository;

import com.access.data.connection.ConnectionConst;
import com.access.data.domain.Member;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;

import static com.access.data.connection.ConnectionConst.*;

class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void setUp() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        repository = new MemberRepositoryV1(dataSource);
    }

    @Test
    void save() throws SQLException {
        Member member = new Member("memberV0", 10_000);
        repository.save(member);
    }
}