package com.raindown.tests.douyu.zhudouyu;


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

    private static Runnable task;

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(20);

        RequestTaskDouYu task = new RequestTaskDouYu();
        long min=1000*60;
        long hour=1000*60*60;
        long initialDelay = 0; // 初始延迟时间（单位：秒）
        int period = 400; // 任务执行的周期间隔（单位：秒）

        executorService.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.MILLISECONDS);
        while (true){
            if (task.flag){
                executorService.shutdownNow();//关闭线程池
                return;
            }
        }

    }



}
