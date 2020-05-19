package com.wf.demo.thread;

import java.util.concurrent.*;

/**
 * @author wf
 * @create 2020-05-17 21:36
 * @desc
 **/
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(
                2,
                5,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 1; i <= 10; i++) {
                service.execute(() -> {
                    System.out.println((Thread.currentThread().getName() + "\t 办理业务"));
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }

    private static void threadPoolDemo() {
        // ExecutorService executorService = Executors.newFixedThreadPool(5);
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            for (int i = 1; i <= 10; i++) {
                executorService.execute(() -> {
                    System.out.println((Thread.currentThread().getName() + "\t 办理业务"));
                });
            }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
