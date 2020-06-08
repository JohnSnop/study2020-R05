package com.wf.demo.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author wf
 * @create 2020-06-07 21:02
 * @desc
 **/
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // referenceQueueDemo();
        phantomReferenceDemo();
    }

    private static void phantomReferenceDemo() throws InterruptedException {
        Object object = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> weakReference = new PhantomReference<>(object, queue);

        System.out.println(object);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());

        object = null;
        System.gc();

        Thread.sleep(500);
        System.out.println(object);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());

    }

    private static void referenceQueueDemo() throws InterruptedException {
        Object object = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(object, queue);

        System.out.println(object);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());

        object = null;
        System.gc();

        Thread.sleep(500);
        System.out.println(object);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());
    }
}
