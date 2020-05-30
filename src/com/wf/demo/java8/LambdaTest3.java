package com.wf.demo.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wf
 * @create 2020-05-30 20:54
 * @desc
 **/
public class LambdaTest3 {

    @Test
    public void test1() {
        Consumer<String> con = (str) -> System.out.println(str);
        con.accept("Hello");
        System.out.println();

        Consumer<String> con1 = System.out :: println;
        con1.accept("Hello");
    }

    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compareTo;
    }

    @Test
    public void test3() {
        BiPredicate<String, String> bi = (x, y) -> x.equals(y);

        BiPredicate<String, String> bi1 = String::equals;

        System.out.println(bi.test("Hello", "hello"));
        System.out.println(bi1.test("Hello", "hello"));
    }

    /**
     * 构造器引用
     */
    @Test
    public void test4() {
        Supplier<Employee> em = () -> new Employee();

        Supplier<Employee> em1 = Employee::new;
    }

    @Test
    public void test5() {
        Function<Integer, Employee> fun = x -> new Employee(x);

        Function<Integer, Employee> fun1 = Employee::new;
        System.out.println(fun1.apply(100));
    }

    /**
     * 数组引用
     */
    @Test
    public void test6() {
        Function<Integer, String[]> fun = x -> new String[x];
        System.out.println(fun.apply(5).length);

        Function<Integer, String[]> fun2 = String[]::new;
        System.out.println(fun.apply(6).length);
    }
}
