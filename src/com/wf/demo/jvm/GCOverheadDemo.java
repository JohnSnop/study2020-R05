package com.wf.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wf
 * @create 2020-06-08 21:15
 * @desc
 **/
public class GCOverheadDemo {
    // -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
            // java.lang.OutOfMemoryError: GC overhead limit exceeded
        } catch (Throwable t) {
            System.out.println("*********i= " + i);
            t.printStackTrace();
            throw t;
        }
    }
}
