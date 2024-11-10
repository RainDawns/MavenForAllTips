package com.raindown.service;

/**
 * date: 2024/4/26
 *
 * @author raindown
 */

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有一批订单(订单号和订单价格)录入系统
 * 运行过程中可以执行以下操作：添加订单、删除订单、修改订单价格（订单号不存在修改失败）、计算
 * 价格、根据订单号获取价格
 * 实时计算所有订单中当前的最大价格、最小价格和平均价格
 * 请尽可能地降低复杂度
 */
public class OrderService {

    //1kw  100条   8.全部发？  拿出来放redis?  一波一波拿肯定不对   线程池  并发拿
    // 下游无限制    需不需要处理下游返回结果(有多少条失败？)
    //失败需要重发？
    /**
     * 请实现以下未实现的方法
     *
     *
     */
    private  ConcurrentHashMap<Integer, Integer> orders = new ConcurrentHashMap<>();
    private  AtomicInteger totalPrice = new AtomicInteger(0);
    private  AtomicInteger count = new AtomicInteger(0);

    // 添加订单
    public void add(int id, int price) {
        orders.put(id, price);
        count.incrementAndGet();
        totalPrice.addAndGet(price);
    }

    // 移除订单
    public void remove(int id){
        Integer removedPrice = orders.remove(id);
        if (removedPrice != null) {
            count.decrementAndGet();
            totalPrice.addAndGet(-removedPrice);
        }
    }

    // 更改订单
    public void modify(int id,int newPrice) {
        Integer existingPrice = orders.get(id);
        if (existingPrice != null) {
            totalPrice.addAndGet(newPrice - existingPrice);
            orders.put(id, newPrice);
        }
    }

    // 获取订单价格
    public int getPrice(int id) {
        return orders.getOrDefault(id, -1);
    }

    // 最低价格
    public int minPrice() {
        return orders.values().stream().mapToInt(Integer::intValue).min().orElse(-1);
    }

    // 最高价格
    public int maxPrice() {
        return orders.values().stream().mapToInt(Integer::intValue).max().orElse(-1);
    }

    // 平均价格a
    public int avgPrice() {
        int numOrders = count.get();
        int total = totalPrice.get();
        return numOrders > 0 ? total / numOrders : 0;
    }

}
