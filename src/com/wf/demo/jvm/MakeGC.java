package com.wf.demo.jvm;

/**
 * @author wf
 * @create 2020-05-25 21:48
 * @desc
 **/
public class MakeGC {
    // -Xms10m -Xmx10m -XX:+PrintGCDetails
    public static void main(String[] args) {
        byte[] bytes = new byte[50 * 1024 * 1024];
    }
}
