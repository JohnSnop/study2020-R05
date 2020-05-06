package com.wf.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-05-06 21:34
 * @desc
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // before();
        CountDownLatch downLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 加班中。。。");
                downLatch.countDown();
            }, CountryEnum.getCountry(i).name).start();
        }
        downLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 下班走人");
    }

    private static void before() {
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 加班中。。。");
            }, String.valueOf(i)).start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t 下班走人");
    }
}
