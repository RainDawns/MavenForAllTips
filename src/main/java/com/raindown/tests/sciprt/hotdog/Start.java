package com.raindown.tests.sciprt.hotdog;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/7/14 20:28
 * @version: 1.0
 */
public class Start {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);

        Runnable task = new RequestTask();

        int initialDelay = 0; // 初始延迟时间（单位：毫秒）
        int period = 500; // 任务执行的周期间隔（单位：毫秒）

        executorService.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.MILLISECONDS);
    }



}
