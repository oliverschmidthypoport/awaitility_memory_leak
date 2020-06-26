package com.example.demo;

import org.awaitility.core.ConditionTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.awaitility.pollinterval.FibonacciPollInterval.fibonacci;

@RestController
public class DemoController {

    @Autowired
    @Qualifier("customExecutor")
    Executor taskExecutor;

    @GetMapping("awaitility")
    public String awaitility() {
        taskExecutor.execute(() -> {
            try {
                await().atMost(1, SECONDS).pollInterval(fibonacci()).until(() -> false);
            } catch (ConditionTimeoutException e) {

            }
        });
        return "done";
    }
}