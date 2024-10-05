package com.raindown.tests.sciprt.douyu;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/7/14 20:28
 * @version: 1.0
 */
public class Startzhu {


    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        RequestTaskDouYu1005 task = new RequestTaskDouYu1005();

        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        // 设置目标时间为当天的18:59:58
        LocalDateTime targetTime = now.withHour(18).withMinute(59).withSecond(58).withNano(0);

        // 如果当前时间已经超过目标时间，则将目标时间设为第二天的18:59:58
        if (now.isAfter(targetTime)) {
            targetTime = targetTime.plusDays(1);
        }

        // 计算初始延迟（毫秒）
        long initialDelay = ChronoUnit.MILLIS.between(now, targetTime);

        // 设置任务执行的周期（例如，每1秒执行一次）
        long period = 100; // 毫秒

        // 使用计算出的初始延迟和周期来调度任务
        executorService.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.MILLISECONDS);

        // 监控任务的执行状态，决定是否关闭线程池
        while (true) {
            if (task.flag) {
                executorService.shutdownNow(); // 关闭线程池
                return;
            }
        }
    }
}