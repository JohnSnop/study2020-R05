package com.wf.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wf
 * @create 2020-05-05 12:56
 * @desc
 **/
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5, 2020);
        System.out.println(atomicInteger.get());
    }
}
