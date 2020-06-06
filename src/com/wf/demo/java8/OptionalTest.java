package com.wf.demo.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * @author wf
 * @create 2020-06-02 21:46
 * @desc
 **/
public class OptionalTest {

    @Test
    public void test3() {
        Optional<Employee> op = Optional.ofNullable(null);
        Employee employee = op.orElseGet(() -> new Employee());
        System.out.println(employee);
    }

    @Test
    public void test2() {
        Optional<Employee> empty = Optional.empty();
        if (empty.isPresent())
        System.out.println(empty.get());

        Optional<Employee> employee = Optional.ofNullable(new Employee());
        System.out.println(employee.get());
    }

    @Test
    public void test1() {
        Optional<Employee> employee = Optional.of(new Employee());
        System.out.println(employee.get());

        Optional optionalO = Optional.of(null);
        System.out.println(optionalO);
    }
}
