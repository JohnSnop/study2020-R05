package com.wf.demo.concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-08-06 21:58
 * @desc
 **/
public class ThreadStateTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());

        while (!thread.getState().equals(Thread.State.TERMINATED)) {
            System.out.println(thread.getState());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(thread.getState());
    }

    @Test
    public void testDaemon() {
        Thread thread = new Thread(() -> {
            System.out.println("Hello");
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Test
    public void testPriority() {
        Thread thread = new Thread(() -> {
            System.out.println("Hello");
        });
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        System.out.println(thread.getPriority());
    }
}
