package com.wf.demo.java8;

/**
 * @author wf
 * @create 2020-05-30 19:26
 * @desc
 **/
@FunctionalInterface
public interface MyFunc<T, R> {
    R getVal(T t1, T t2);
}
