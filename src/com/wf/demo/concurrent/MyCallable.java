package com.wf.demo.concurrent;

import java.util.concurrent.*;

/**
 * @author wf
 * @create 2020-08-02 10:19
 * @desc
 **/
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable1 = new MyCallable();
        MyCallable callable2 = new MyCallable();
        MyCallable callable3 = new MyCallable();
        ExecutorService service = Executors.newCachedThreadPool();

        Future<Integer> submit1 = service.submit(callable1);
        Future<Integer> submit2 = service.submit(callable2);
        Future<Integer> submit3 = service.submit(callable3);

        System.out.println(submit1.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());

        service.shutdown();
    }
}
