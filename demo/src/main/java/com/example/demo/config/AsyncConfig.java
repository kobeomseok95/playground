package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);                // 실행을 대기하고 있는 쓰레드 갯수
        executor.setMaxPoolSize(2);                // 동시에 동작하는 최대 쓰레드 갯수
        /**
         * QueueCapacity : MaxPoolSize를 초과하는 요청이 Thread 생성 요청시
         * 해당 내용을 큐에 저장한다.
         * 사용할 수 있는 Thread 여유 자리가 발생하면 큐에서 하나씩 꺼내서 동작한다.
         */
        executor.setQueueCapacity(2);
        executor.setThreadNamePrefix("Async-");     // 스프링이 생성하는 쓰레드의 접두사
        executor.initialize();                      // 초기화
        return executor;
    }
}
