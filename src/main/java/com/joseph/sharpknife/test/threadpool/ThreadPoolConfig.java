package com.joseph.sharpknife.test.threadpool;

import com.joseph.sharpknife.blade.pool.MonitoredThreadPool;
import com.joseph.sharpknife.blade.pool.ThreadPoolBuilder;
import com.joseph.sharpknife.blade.pool.ThreadPoolEnums;
import com.joseph.sharpknife.blade.pool.ThreadPoolFactory;
import com.joseph.sharpknife.blade.queue.DefaultMonitoredQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author Joseph
 * @since 2022/3/6 9:45 PM
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public MonitoredThreadPool commonThreadPool() {
        ThreadPoolBuilder builder = new ThreadPoolBuilder(
                ThreadPoolEnums.DEFAULT,
                "commonThreadPool",
                6,
                36,
                60,
                TimeUnit.SECONDS,
                new DefaultMonitoredQueue<>(10),
                null,
                null
        );
        return ThreadPoolFactory.build(builder);
    }

    @Bean
    public MonitoredThreadPool productListThreadPool() {
        ThreadPoolBuilder builder = new ThreadPoolBuilder(
                ThreadPoolEnums.DEFAULT,
                "productListThreadPool",
                32,
                32,
                60,
                TimeUnit.SECONDS,
                new DefaultMonitoredQueue<>(10),
                null,
                null
        );
        return ThreadPoolFactory.build(builder);
    }


}
