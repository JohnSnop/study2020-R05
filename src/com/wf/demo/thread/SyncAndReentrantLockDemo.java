package com.wf.demo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wf
 * @create 2020-05-08 22:23
 * @desc
 **/
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareData2 shareData2 = new ShareData2();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                shareData2.printDemo(5);
            }
        }, "T1").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                shareData2.printDemo(10);
            }
        }, "T2").start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                shareData2.printDemo(15);
            }
        }, "T3").start();
    }
}

class ShareData2 {
    private int num = 5;
    private int step = 5;
    static Map<Integer, Condition> map = new HashMap<>();
    private static Lock lock = new ReentrantLock();
    static {
        map.put(5, lock.newCondition());
        map.put(10, lock.newCondition());
        map.put(15, lock.newCondition());
    }

    public void printDemo(int time) {
        lock.lock();
        try {
            // 等待
            while (num != time) {
                map.get(time).await();
            }
            // 干活
            for (int i = 1; i <= time; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知
            num += step;
            if (num > 3 * step) {
                num = step;
            }
            map.get(num).signal();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	lock.unlock();
        }
    }
}
