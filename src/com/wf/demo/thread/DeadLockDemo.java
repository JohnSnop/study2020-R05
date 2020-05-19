package com.wf.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-05-19 22:01
 * @desc
 **/
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new ShareData3(lockA, lockB), "AAA").start();
        new Thread(new ShareData3(lockB, lockA), "BBB").start();
    }
}

class ShareData3 implements Runnable{
    private String lockA;
    private String lockB;

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println((Thread.currentThread().getName() + "\t 自己持有：" + lockA + "，尝试获取：" + lockB));
            try {
            	TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println((Thread.currentThread().getName() + "\t 自己持有：" + lockA));
            }
        }
    }

    public ShareData3(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
}
