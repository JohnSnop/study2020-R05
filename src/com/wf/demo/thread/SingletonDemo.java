package com.wf.demo.thread;

/**
 * @author wf
 * @create 2020-05-05 10:57
 * @desc 单例模式-volatile
 **/
public class SingletonDemo {
    private SingletonDemo() {
        System.out.println("构造完成");
    }

    private static volatile SingletonDemo instance = null;

    // DCL （double check lock 双端检锁机制）
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
