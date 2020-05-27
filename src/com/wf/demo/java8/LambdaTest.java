package com.wf.demo.java8;

import org.junit.Test;

import java.util.*;

/**
 * @author wf
 * @create 2020-05-27 21:32
 * @desc
 **/
public class LambdaTest {

    List<Employee> list = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 3333.99),
            new Employee("王五", 50, 5555.99),
            new Employee("赵六", 26, 4444.99),
            new Employee("田七", 15, 6666.99)
    );

    public List<Employee> fliterBy(List<Employee> list, MyPredicate<Employee> myPredicate) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : list) {
            if (myPredicate.test(employee)) {
                result.add(employee);
            }
        }
        return result;
    }
    @Test
    public void test6() {
        list.stream()
            .filter(e -> e.getSalary() > 5000)
            .limit(2)
            .forEach(System.out::println);

        System.out.println();
        list.stream()
            .map(Employee::getName)
            .forEach(System.out::println);
    }

    @Test
    public void test5() {
        List<Employee> employees = fliterBy(list, (e) ->
                e.getSalary() > 5000);
        employees.forEach(System.out :: println);
    }

    @Test
    public void test4() {
        List<Employee> employees = fliterBy(list, new FilterEmployeeBySalay());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test3() {
        List<Employee> employees = fliterBy(list, new FilterEmployeeByAge());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(com);
        treeSet.add(21);
        treeSet.add(112);
        treeSet.add(11);
        treeSet.add(12);
        System.out.println(treeSet);
    }

    @Test
    public void test2() {
        TreeSet<Integer> treeSet = new TreeSet<>((x, y) ->
                Integer.compare(x, y));
    }
}
