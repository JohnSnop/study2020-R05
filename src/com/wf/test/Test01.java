package com.wf.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wf
 * @create 2020-07-11 22:37
 * @desc
 **/
public class Test01 {
    @Test
    public void test1() {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(-1 << 1));
    }

    @Test
    public void test2() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();
        System.out.println(hashMap.size());
        hashMap.put(1, 1);
    }
}
