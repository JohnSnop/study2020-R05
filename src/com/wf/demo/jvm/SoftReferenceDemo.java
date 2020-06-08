package com.wf.demo.jvm;

import java.lang.ref.SoftReference;

/**
 * @author wf
 * @create 2020-06-07 17:34
 * @desc
 **/
public class SoftReferenceDemo {

    public static void main(String[] args) {
        // softReferenceEnough();
        softReferenceNotEnough();
    }

    private static void softReferenceEnough() {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);

        System.out.println(object);
        System.out.println(softReference.get());

        object = null;
        System.gc();
        System.out.println(object);
        System.out.println(softReference.get());
    }

    /**
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    private static void softReferenceNotEnough() {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);

        System.out.println(object);
        System.out.println(softReference.get());

        object = null;
        try {
            byte[] arr = new byte[30 * 1024 * 1024];
        } catch (Throwable t) {

        } finally {
            System.out.println(object);
            System.out.println(softReference.get());
        }
    }
}
