package com.wf.demo.thread;

/**
 * @author wf
 * @create 2020-05-05 10:41
 * @desc
 **/
public class ReSortDemo {
    int a = 0;
    boolean flag = false;

    void method1() {
        a = 1;
        flag = true;
    }
    void method2() {
        if (flag) {
            a += 5;
            System.out.println("a value:" + a);
        }
    }
}
