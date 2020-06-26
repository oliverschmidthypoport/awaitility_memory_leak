package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean(name = "customExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
        poolExecutor.setCorePoolSize(1);
        poolExecutor.setMaxPoolSize(1);
        poolExecutor.setThreadNamePrefix("customPoolExecutor");
        poolExecutor.initialize();
        return poolExecutor;
    }
}
