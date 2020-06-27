package com.wf.demo.jvm;

import sun.misc.VM;

import java.nio.ByteBuffer;

/**
 * @author wf
 * @create 2020-06-08 21:28
 * @desc
 **/
public class DirectBufferMemoryDemo {
    // -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
    public static void main(String[] args) {
        System.out.println(VM.maxDirectMemory() / 1024.0/ 1024 + ":MB");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);

    }
}
