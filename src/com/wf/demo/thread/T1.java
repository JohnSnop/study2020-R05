package com.wf.demo.thread;

/**
 * @author wf
 * @create 2020-05-04 21:20
 * @desc    javap 查看字节码
 **/
public class T1 {
    volatile int num = 0;
    void add() {
        num ++;
    }
}
