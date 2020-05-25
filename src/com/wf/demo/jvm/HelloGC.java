package com.wf.demo.jvm;

/**
 * @author wf
 * @create 2020-05-24 22:07
 * @desc
 **/
public class HelloGC {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(totalMemory);
        System.out.println(maxMemory);

        System.out.println(totalMemory/1024.0/1024.0 + "MB");
        System.out.println(maxMemory/1024.0/1024.0 + "MB");
    }
}
