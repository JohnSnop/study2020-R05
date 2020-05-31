package com.wf.demo.java8;

import lombok.*;

/**
 * @author wf
 * @create 2020-05-27 21:39
 * @desc
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private double salary;

    private STATUS status;

    public Employee(int age) {
        this.age = age;
    }

    public enum STATUS {
        FREE,
        BUSY,
        HOLIDAY;
    }
}
