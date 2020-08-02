package com.wf.demo.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-07-29 22:00
 * @desc 线程安全问题
 **/
public class MyThread implements Runnable {
    private int num = 10;

    @Override
    public void run() {
        while (true) {
            if (num <= 0) {
                break;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "--获得了：" + num --);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread, "T1").start();
        new Thread(myThread, "T2").start();
        new Thread(myThread, "T3").start();
        new Thread(myThread, "T4").start();

    }
}
