package com.wf.demo.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author wf
 * @create 2020-05-27 21:39
 * @desc
 **/
@Data
@AllArgsConstructor
@ToString
public class Employee {
    private String name;
    private int age;
    private double salary;
}
