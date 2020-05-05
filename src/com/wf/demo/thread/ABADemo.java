package com.wf.demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wf
 * @create 2020-05-05 15:22
 * @desc
 **/
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100, 1);
    public static void main(String[] args) {
        // testABA();
        new Thread(() -> {
            try {
            	TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
            stampedReference.compareAndSet(100, 101,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);
            stampedReference.compareAndSet(101, 100,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);
        }, "T3").start();
        new Thread(() -> {
            stampedReference.compareAndSet(100, 2020,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println(stampedReference.getStamp());
            System.out.println(stampedReference.getReference());
        }, "T4").start();
    }

    private static void testABA() {
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "T1").start();

        new Thread(() -> {
            try {
            	TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
            atomicReference.compareAndSet(100, 2020);
            System.out.println(atomicReference.get());
        }, "T2").start();
    }
}
