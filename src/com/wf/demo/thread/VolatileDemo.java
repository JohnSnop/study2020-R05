package com.wf.demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wf
 * @create 2020-05-04 18:42
 * @desc 验证volatile可见性
 **/
public class VolatileDemo {
    public static void main(String[] args) {
        // volatileSeeOk();
        Mydata mydata = new Mydata();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    // mydata.addPlusPlus();
                    mydata.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        // 等待上面的线程执行完毕
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        // System.out.println(Thread.currentThread().getName() + "\t num is " + mydata.num);
        System.out.println(Thread.currentThread().getName() + "\t num is " + mydata.atomicInteger);
    }

    private static void volatileSeeOk() {
        Mydata mydata = new Mydata();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mydata.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t num value" + mydata.num);
        }, "AAA").start();
        // main线程
        while (mydata.num == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\t main is over");
    }
}

/**
 * volatile 不保证原子性
 *
 */
class Mydata {
    // int num = 0;
    // 添加volatile 可见性
    volatile int num = 0;
    void addTo60() {
        num = 60;
    }
    // synchronized是重量级的锁
    /*synchronized*/ void addPlusPlus() {
        num ++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
