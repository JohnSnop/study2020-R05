package com.wf.demo.jvm;

/**
 * @author wf
 * @create 2020-06-23 22:25
 * @desc
 **/
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();// Exception in thread "main" java.lang.StackOverflowError
    }
}
