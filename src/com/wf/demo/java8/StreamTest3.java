package com.wf.demo.java8;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wf
 * @create 2020-05-31 18:23
 * @desc
 **/
public class StreamTest3 {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream()
                .reduce(Integer::sum).get());

    }

    @Test
    public void test2() {
        System.out.println(StreamTest2.list
                .stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum));
    }

    @Test
    public void test3() {
        StreamTest2.list
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        StreamTest2.list
                .stream()
                .collect(Collectors.groupingBy(Employee::getStatus))
                .forEach((k, v) -> {
                    System.out.println(k);

                    System.out.println(v);
                });
    }

    @Test
    public void test5() {
        System.out.println(StreamTest2.list
                .stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary)).getMax());

    }
}
