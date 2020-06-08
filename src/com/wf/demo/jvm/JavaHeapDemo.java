package com.wf.demo.jvm;

import java.util.Random;

/**
 * @author wf
 * @create 2020-06-07 22:21
 * @desc
 **/
public class JavaHeapDemo {
    // -xms5m -xmx5m
    public static void main(String[] args) {
        byte[] arr = new byte[20 * 1024 * 1024];
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
