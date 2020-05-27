package com.wf.demo.java8;

/**
 * @author wf
 * @create 2020-05-27 21:47
 * @desc
 **/
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 35;
    }
}
