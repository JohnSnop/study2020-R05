package com.wf.demo.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author wf
 * @create 2020-05-31 21:05
 * @desc
 **/
public class ForkJoinTest {
    @Test
    public void test1() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0, 100000000L);
        Long invoke = pool.invoke(task);

        System.out.println(invoke);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test2() {
        Instant start = Instant.now();
        long sum = 0;
        for (long i = 0; i <= 100000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test3() {
        Instant start = Instant.now();
        System.out.println(LongStream.rangeClosed(0, 100000000L)
                .reduce(0, Long::sum));
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test4() {
        Instant start = Instant.now();
        System.out.println(LongStream.rangeClosed(0, 100000000L)
                .parallel()
                .reduce(0, Long::sum));
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis());
    }
}
