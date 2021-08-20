package com.example.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SkipCheckingListener extends StepExecutionListenerSupport {

    public ExitStatus afterStep(StepExecution stepExecution) {
        String exitCode = stepExecution.getExitStatus().getExitCode();
        if (checkSkipNotFailed(stepExecution, exitCode)) {
            return new ExitStatus("COMPLETED WITH SKIPS");
        }
        return null;
    }

    private boolean checkSkipNotFailed(StepExecution stepExecution, String exitCode) {
        return !exitCode.equals(ExitStatus.FAILED.getExitCode())
                && stepExecution.getSkipCount() > 0;
    }
}
