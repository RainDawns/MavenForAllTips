package com.raindown.practise;

import org.checkerframework.checker.units.qual.K;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * date: 2024/4/21
 *
 * @author raindown
 */
public class Main1 {

    private static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

    private static HashMap<String,Integer> cache=new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println("put:"+i);
                map.put(i, String.valueOf(i));
            }
        }).start();
        Thread.sleep(10);
        new Thread(()->{
            for (Map.Entry<Integer, String>  entry:map.entrySet()){
                map.remove(entry.getKey());
                System.out.println("remove:"+entry.getKey());
            }
        }).start();
    }
}
