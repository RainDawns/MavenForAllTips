package com.raindown.tests.five_ailiPay;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/7/17 12:45
 * @version: 1.0
 */
public class StartAiliPay {
    public static void main(String[] args) {

        int numThreads = 10; // 并发请求的线程数量
        int delay = 3; // 请求的时间间隔，单位为秒

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            executor.scheduleAtFixedRate(new AiliPay() , 0, delay, TimeUnit.SECONDS);
        }
    }
}
