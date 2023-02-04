package com.example.batch.job.helloworld;

import com.example.batch.job.SpringBatchTestConfig;
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

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBatchTest
@SpringBootTest(classes = {
        SpringBatchTestConfig.class,
        HelloWorldJobConfiguration.class,
})
@ActiveProfiles("test")
class HelloWorldJobConfigurationTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @DisplayName("배치 테스트 - 성공")
    @Test
    public void success() throws Exception {
        JobExecution execution = jobLauncherTestUtils.launchJob();

        assertEquals(execution.getExitStatus(), ExitStatus.COMPLETED);
    }
}