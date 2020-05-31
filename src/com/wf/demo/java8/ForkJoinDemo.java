package com.wf.demo.java8;

import java.util.concurrent.RecursiveTask;

/**
 * @author wf
 * @create 2020-05-31 20:55
 * @desc
 **/
public class ForkJoinDemo extends RecursiveTask<Long> {

    private long start;
    private long end;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    private static final long THRESHOLD = 10000L;

    @Override
    protected Long compute() {
        if ((end - start) <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, middle);
            left.fork();

            ForkJoinDemo right = new ForkJoinDemo(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
