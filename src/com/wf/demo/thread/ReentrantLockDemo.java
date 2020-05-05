package com.wf.demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wf
 * @create 2020-05-05 20:14
 * @desc
 **/
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendMsg();
        }, "T1").start();

        new Thread(() -> {
            phone.sendMsg();
        }, "T2").start();

        try {
        	TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.println();

        new Thread(phone, "t3").start();
        new Thread(phone, "t4").start();
    }
}

class Phone implements Runnable {
    synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getName() + "\t sendMsg()");
        sendEmain();
    }

    synchronized void sendEmain() {
        System.out.println(Thread.currentThread().getName() + "\t ####sendEmain()");
    }

    @Override
    public void run() {
        get();
    }

    Lock lock = new ReentrantLock();

    private void get() {
        lock.lock();
        // lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get()()");
            set();
        } finally {
            // lock.unlock();
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ####set()()");
        } finally {
            lock.unlock();
        }
    }
}