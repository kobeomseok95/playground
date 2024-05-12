package com.example.asyncevents.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableAsync
class AsyncConfig : AsyncConfigurer {

    // @Bean
    // fun threadPoolTaskExecutor(): Executor {
    //     return ThreadPoolTaskExecutor().apply {
    //         this.corePoolSize = 5
    //         this.maxPoolSize = 10
    //         this.queueCapacity = 10
    //         this.setThreadNamePrefix("task-")
    //         this.initialize()
    //     }
    // }

    override fun getAsyncExecutor(): Executor? {
        return ThreadPoolTaskExecutor().apply {
            this.corePoolSize = 5
            this.maxPoolSize = 10
            this.queueCapacity = 10
            this.setThreadNamePrefix("task-")
            this.initialize()
        }
    }
}
