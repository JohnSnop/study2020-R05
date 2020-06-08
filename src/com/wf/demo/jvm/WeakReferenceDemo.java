package com.wf.demo.jvm;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author wf
 * @create 2020-06-07 17:44
 * @desc
 **/
public class WeakReferenceDemo {
    public static void main(String[] args) {
        // weakReferenceDemo();
        weakHashMapDemo();
    }

    private static void weakHashMapDemo() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = 1;
        // Integer key = 128;
        // Integer key = new Integer(1);

        map.put(key, "Hello");
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void weakReferenceDemo() {
        Object object = new Object();

        WeakReference<Object> weakReference = new WeakReference<>(object);
        System.out.println(object);
        System.out.println(weakReference.get());

        object = null;
        System.gc();

        System.out.println(object);
        System.out.println(weakReference.get());
    }


}
