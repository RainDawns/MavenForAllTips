package com.raindown.service.thread;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/5/27 17:16
 * @version: 1.0
 */
public class MoreSyncThread<T,R> {

    /**
     * @description:  分批次异步执行相关耗时操作并返回相关结果
     * @author: luoNe_ngHai
     * @param list 需要的分批处理的数据
     * @param function 对数据处理的方式  输入值为list   输出值为list<R>
     * @param size  将数据分批  其中每一批的数据量
     * @return: List<R>  返回的数据 result
     */
    public List<R> syncGetMoreResult(List<T> list, Functions<T, R> function, int size) {
        List<List<T>> partition = Lists.partition(list, size);
        // 创建ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(partition.size());

        // 处理每个批次的任务
        List<CompletableFuture<List<R>>> futureList = new ArrayList<>();
        for (List<T> batch : partition) {
            // 创建CompletableFuture对象
            CompletableFuture<List<R>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
                List<R> result = function.apply(batch);
                return result;
            }, executorService).whenComplete((resultList, throwable) -> {
                if (throwable != null) {
                    // 处理异常
                    System.err.println("Error occurred: " + throwable.getMessage());
                }
            });
            // 将CompletableFuture对象加入列表
            futureList.add(listCompletableFuture);
        }
        // 等待所有CompletableFuture对象都完成
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
        // 合并所有结果
        List<R> finalResultList = new ArrayList<>();
        for (CompletableFuture<List<R>> future : futureList) {
            finalResultList.addAll(future.join());
        }
        // 关闭ExecutorService
        executorService.shutdown();
        return finalResultList;
    }

    public  static  void  getNextValue(String str){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,
                15, 2, TimeUnit.SECONDS, new ArrayBlockingQueue(10000),new ThreadPoolExecutor.AbortPolicy());
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(str);
            }
        });
        pool.shutdown();
    }

    public static void main(String[] args) {
        getNextValue("str");
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
    }
}
