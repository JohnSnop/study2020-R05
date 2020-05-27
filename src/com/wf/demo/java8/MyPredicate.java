package com.wf.demo.java8;

/**
 * @author wf
 * @create 2020-05-27 21:46
 * @desc
 **/
@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
    // Object的方法
    boolean equals(Object t);
}
