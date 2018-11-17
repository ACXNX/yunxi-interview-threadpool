package com.yunxi.threadpool.interviewthreadpool.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 无双
 * @Date 2018/11/14
 * @Description
 */
@Configuration
public class ThreadPool {

    @Bean
    public ExecutorService getConfigureThreadPool() {
        return Executors.newCachedThreadPool();
    }
}
