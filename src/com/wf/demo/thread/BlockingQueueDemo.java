package com.wf.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-05-08 21:18
 * @desc
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        // exception(blockingQueue);
        // ok(blockingQueue);
        // also(blockingQueue);
        timeout(blockingQueue);
    }

    private static void timeout(BlockingQueue<String> blockingQueue) throws InterruptedException {
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
    }

    private static void also(BlockingQueue<String> blockingQueue) throws InterruptedException {
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // blockingQueue.put("x");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // System.out.println(blockingQueue.take());
    }

    private static void ok(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    private static void exception(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // System.out.println(blockingQueue.remove());
    }
}
