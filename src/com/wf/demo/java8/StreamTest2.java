package com.wf.demo.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author wf
 * @create 2020-05-31 18:06
 * @desc
 **/
public class StreamTest2 {

    static List<Employee> list = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.STATUS.BUSY),
            new Employee("李四", 38, 3333.99, Employee.STATUS.BUSY),
            new Employee("王五", 50, 5555.99, Employee.STATUS.FREE),
            new Employee("赵六", 26, 4444.99, Employee.STATUS.BUSY),
            new Employee("田七", 15, 6666.99, Employee.STATUS.BUSY)
    );

    @Test
    public void test1() {
        System.out.println(list.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.STATUS.BUSY)));
    }

    @Test
    public void test2() {
        System.out.println(list.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.STATUS.BUSY)));
    }

    @Test
    public void test3() {
        System.out.println(list.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.STATUS.BUSY)));
    }

    @Test
    public void test4() {
        System.out.println(list.stream()
                .findFirst());
    }

    @Test
    public void test5() {
        System.out.println(list.stream()
                .count());

        System.out.println(list.stream()
                .map(Employee::getSalary)
                .max(Double::compare)
                .get());

        System.out.println(list.stream()
                .map(Employee::getSalary)
                .min(Double::compare)
                .get());

    }
}
