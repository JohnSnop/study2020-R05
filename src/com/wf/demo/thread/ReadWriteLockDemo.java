package com.wf.demo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wf
 * @create 2020-05-06 20:55
 * @desc
 **/
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                cache.put(finalI + "", finalI + "");
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                cache.get(finalI + "");
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> cache = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            cache.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成：" + key);
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	lock.writeLock().unlock();
        }
    }
    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：" + key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + cache.get(key));
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	lock.readLock().unlock();
        }
    }
    public void clear() {
        cache.clear();
    }

}
