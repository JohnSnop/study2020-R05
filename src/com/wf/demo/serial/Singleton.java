package com.wf.demo.serial;

import java.io.Serializable;

/**
 * @author wf
 * @create 2020-05-31 16:00
 * @desc
 **/
public class Singleton implements Serializable {
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
    // 防止反序列化，破坏单例
    private Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
