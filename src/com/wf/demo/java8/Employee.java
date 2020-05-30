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
    private String name;
    @NonNull
    private int age;
    private double salary;
}
