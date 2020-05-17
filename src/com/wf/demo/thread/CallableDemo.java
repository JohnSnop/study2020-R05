package com.wf.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-05-17 18:15
 * @desc
 **/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask).start();
        new Thread(futureTask).start();

        while (!futureTask.isDone())
        System.out.println(futureTask.get());

    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println("Callable come in");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1024;
    }
}
