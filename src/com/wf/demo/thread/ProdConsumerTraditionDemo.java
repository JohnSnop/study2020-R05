package com.wf.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wf
 * @create 2020-05-08 21:53
 * @desc    一个初始值为0的变量，两个线程一个加1，一个减1，来5轮
 **/
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T1").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2").start();
    }
}

class ShareData {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void incr() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (num != 0) {
                // 等待
                condition.await();
            }
            num ++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	lock.unlock();
        }

    }
    public void decr() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (num == 0) {
                // 等待
                condition.await();
            }
            num --;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}