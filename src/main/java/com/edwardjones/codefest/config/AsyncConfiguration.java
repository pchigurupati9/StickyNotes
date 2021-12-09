package com.edwardjones.codefest.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Set configurations required for asynchronous thread executor
 */
@Configuration
public class AsyncConfiguration {

    @Value("${general.thread.await-term-secs:5}")
    private int genAwaitTermSecs;

    @Value("${general.thread.core-pool-size:200}")
    private int genCorePoolSize;

    @Value("${general.thread.keep-alive-secs:120}")
    private int genKeepAliveSecs;

    @Value("${general.thread.max-pool-size:400}")
    private int genMaxPoolSize;

    // keep this as 0 to make deadlocking impossible
    @Value("${general.thread.queue-capacity:0}")
    private int genQueueCapacity;


    @Bean
    @Qualifier("generalExecutor")
    public Executor generalExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setAwaitTerminationSeconds(genAwaitTermSecs);
        executor.setCorePoolSize(genCorePoolSize);
        executor.setKeepAliveSeconds(genKeepAliveSecs);
        executor.setMaxPoolSize(genMaxPoolSize);
        executor.setQueueCapacity(genQueueCapacity);
        executor.setThreadNamePrefix("GeneralExecutor-");
        // make the caller run the task instead of throwing an exception when
        // the executor is full
        executor.setRejectedExecutionHandler(new CallerRunsPolicy());
        executor.initialize();
//        return new DelegatingSecurityContextAsyncTaskExecutor(executor);
        return executor;
    }

}
