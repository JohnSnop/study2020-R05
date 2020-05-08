package com.wf.demo.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-05-08 21:39
 * @desc
 **/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put a");
                blockingQueue.put("a");

                System.out.println(Thread.currentThread().getName() + "\t put b");
                blockingQueue.put("b");

                System.out.println(Thread.currentThread().getName() + "\t put c");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            try {
            	TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
            try {
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
    }
}
