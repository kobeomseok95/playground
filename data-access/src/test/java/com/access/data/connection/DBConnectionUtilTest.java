package com.access.data.connection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
class DBConnectionUtilTest {

    @Test
    void connection() throws Exception {
        Connection connection = DBConnectionUtil.getConnection();
        assertThat(connection).isNotNull();
    }
}
