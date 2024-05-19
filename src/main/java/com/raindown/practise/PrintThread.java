package com.raindown.practise;

public class PrintThread extends Thread {
    private static Object lock = new Object();
    private static int currentNumber = 1;
    private int threadId;
    private int totalThreads;

    public PrintThread(int threadId, int totalThreads) {
        this.threadId = threadId;
        this.totalThreads = totalThreads;
    }

    @Override
    public void run() {
        while (currentNumber <= 100) {
            synchronized (lock) {
                // 检查是否轮到当前线程打印
                while (currentNumber % totalThreads != threadId) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (currentNumber <= 100) {
                    System.out.println("Thread " + threadId + ": " + currentNumber);
                    currentNumber++;
                }

                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        int totalThreads = 3;

        for (int i = 0; i < totalThreads; i++) {
            PrintThread thread = new PrintThread(i, totalThreads);
            thread.start();
        }
    }
}