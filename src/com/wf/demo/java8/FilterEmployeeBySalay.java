package com.wf.demo.java8;

/**
 * @author wf
 * @create 2020-05-27 21:52
 * @desc
 **/
public class FilterEmployeeBySalay implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
