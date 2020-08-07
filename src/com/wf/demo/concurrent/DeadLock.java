package com.wf.demo.concurrent;

import lombok.val;

import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-08-07 21:53
 * @desc
 **/
public class DeadLock {
    public static void main(String[] args) {
        String lockA = "A";
        String lockB = "B";
        new Thread(new ShareData(lockA, lockB)).start();
        new Thread(new ShareData(lockB, lockA)).start();

    }
}

class ShareData implements Runnable {
    private String lockA;
    private String lockB;
    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "--获得了--" + lockA);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "--获得了--" + lockB);
            }
        }
    }

    protected ShareData(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

}