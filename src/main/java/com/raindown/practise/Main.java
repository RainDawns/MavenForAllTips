package com.raindown.practise;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        String s = new String();
        Object o = new Object();


        AtomicInteger count = new AtomicInteger();
        count.incrementAndGet();

        String str1 = "helloworld";
        String str2 = "hello" + new String("world");
        System.out.println(str1 == str2);

        Thread t = new Thread() {

            public void run() {
//                pong();
                System.out.println(pong());
            }
        };

        t.run();
        System.out.print("ping");

    }
    static int pong() {

        System.out.print("pong");
        try{
            return 1;
        }catch(Exception e){
            return 2;
        }finally{
            return 3;
        }


    }

    Lock lock = new ReentrantLock();





}


