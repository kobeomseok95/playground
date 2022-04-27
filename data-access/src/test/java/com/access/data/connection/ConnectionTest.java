package com.access.data.connection;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.access.data.connection.ConnectionConst.*;

@Slf4j
public class ConnectionTest {

    @Test
    void driverManager() throws Exception {
        Connection conn1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Connection conn2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        log.info("connection = {}, class = {}", conn1, conn1.getClass());
        log.info("connection = {}, class = {}", conn2, conn2.getClass());
    }

    @Test
    void dataSourceDriverManager() throws Exception {
        DataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        useDataSource(dataSource);
    }

    private void useDataSource(DataSource dataSource) throws SQLException {
        Connection conn1 = dataSource.getConnection();
        Connection conn2 = dataSource.getConnection();
        log.info("connection = {}, class = {}", conn1, conn1.getClass());
        log.info("connection = {}, class = {}", conn2, conn2.getClass());
    }

    @Test
    void dataSourceConnectionPool() throws Exception {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaximumPoolSize(10);
        dataSource.setPoolName("myPool");
        useDataSource(dataSource);
        Thread.sleep(1000);
    }

    private void overPoolCountTest(HikariDataSource dataSource) throws SQLException {
        for (int i = 0; i < 11; i++) {
            Connection conn = dataSource.getConnection();
            log.info("connection = {}, class = {}", conn, conn.getClass());
        }
    }
}
