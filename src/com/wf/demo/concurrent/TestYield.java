package com.wf.demo.concurrent;

/**
 * @author wf
 * @create 2020-08-02 21:46
 * @desc
 **/
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "A").start();
        new Thread(myYield, "B").start();
    }
}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始");
        Thread.currentThread().yield();
        System.out.println(Thread.currentThread().getName() + "线程结束");
    }
}
