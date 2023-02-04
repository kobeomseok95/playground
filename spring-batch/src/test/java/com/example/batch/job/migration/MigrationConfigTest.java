package com.example.batch.job.migration;

import com.example.batch.job.SpringBatchTestConfig;
import com.example.batch.job.migration.core.domain.AccountsRepository;
import com.example.batch.job.migration.core.domain.OrderRepository;
import com.example.batch.job.migration.core.domain.Orders;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBatchTest
@SpringBootTest(classes = {
        SpringBatchTestConfig.class,
        MigrationConfig.class,
})
@ActiveProfiles("test")
class MigrationConfigTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AccountsRepository accountsRepository;

    @AfterEach
    public void tearDown() throws Exception {
        orderRepository.deleteAll();
        accountsRepository.deleteAll();
    }

    @Test
    @DisplayName("데이터가 없을 경우")
    public void successNoData() throws Exception {
        JobExecution execution = jobLauncherTestUtils.launchJob();

        assertEquals(execution.getExitStatus(), ExitStatus.COMPLETED);
        assertEquals(0, accountsRepository.count());
    }

    @Test
    @DisplayName("데이터가 있을 경우")
    public void existData() throws Exception {
        orderRepository.saveAll(List.of(
            new Orders(null, "kakao gift", 15000, new Date()),
            new Orders(null, "naver gift", 15000, new Date())
        ));

        JobExecution execution = jobLauncherTestUtils.launchJob();

        assertEquals(execution.getExitStatus(), ExitStatus.COMPLETED);
        assertEquals(2, accountsRepository.count());
    }
}
