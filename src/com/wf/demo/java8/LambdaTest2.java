package com.wf.demo.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author wf
 * @create 2020-05-27 22:05
 * @desc
 **/
public class LambdaTest2 {

    @Test
    public void test3() {
        System.out.println(getIntegerList(5, () -> new Random().nextInt()));
    }

    List<Integer> getIntegerList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    @Test
    public void test1() {
        Runnable runnable = () -> {
            System.out.println("Hello lambbda");
        };
        runnable.run();
    }

    @Test
    public void test2() {
        oper(100L, 200L, (x, y) -> x + y);

        oper(100L, 200L, (x, y) -> x * y);
    }

    void oper(Long num1, Long num2, MyFunc<Long, Long> myFunc) {
        System.out.println(myFunc.getVal(num1, num2));
    }
}
