package com.wf.demo.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-05-06 22:20
 * @desc
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);// 模拟三个车位
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    try {
                    	TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                    	e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
