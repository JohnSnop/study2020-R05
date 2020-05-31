package com.wf.demo.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wf
 * @create 2020-05-31 16:32
 * @desc
 **/
public class StreamTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.stream();

        Stream.iterate(0, (x) -> x + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void test1() {
        list.stream()
                .filter((e) -> {
                    System.out.println("断路");
                    return e.getAge() > 30;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        list.stream()
                .filter((e) -> {
                    System.out.println("断路");
                    return e.getSalary() > 5000;
                })
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println(list);

    }

    @Test
    public void test4() {
        list.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return Integer.valueOf(e1.getAge()).compareTo(Integer.valueOf(e2.getAge()));
                    }
                })
                .forEach(System.out::println);
    }
    List<Employee> list = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 3333.99),
            new Employee("王五", 50, 5555.99),
            new Employee("王五1", 50, 5555.99),
            new Employee("王五2", 50, 5555.99),
            new Employee("赵六", 26, 4444.99),
            new Employee("田七", 15, 6666.99)
    );
}
