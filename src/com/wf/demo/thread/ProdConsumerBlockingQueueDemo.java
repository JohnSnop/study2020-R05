package com.wf.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wf
 * @create 2020-05-17 17:19
 * @desc
 **/
public class ProdConsumerBlockingQueueDemo {
    public static void main(String[] args) {
        AtomicReference<Integer> atomicReference = new AtomicReference<>();
        atomicReference.set(1);
        QueueData<Integer> data = new QueueData<>(atomicReference, new ArrayBlockingQueue<>(5));

        new Thread(() -> {
            try {
                data.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            try {
                data.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {
        	TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        data.stop();
    }
}

class QueueData<T> {
    private AtomicBoolean atomicBoolean = new AtomicBoolean(true);
    private AtomicReference<T> atomicReference;

    BlockingQueue<T> blockingQueue;

    public QueueData(AtomicReference<T> atomicReference, BlockingQueue<T> blockingQueue) {
        this.atomicReference = atomicReference;
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void prod() throws Exception {
        while (atomicBoolean.get()) {
            T t = atomicReference.get();
            boolean offer = blockingQueue.offer(t, 2, TimeUnit.SECONDS);
            if (offer) {
                System.err.println(Thread.currentThread().getName() + "\t 生产成功");
            } else {
                System.err.println(Thread.currentThread().getName() + "\t 生产失败");
            }
            try {
            	TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
        System.err.println(Thread.currentThread().getName() + "\t 生产者暂停");
    }

    public void consumer() throws Exception {
        while (atomicBoolean.get()) {
            T poll = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (poll == null) {
                atomicBoolean.set(false);
                System.err.println(Thread.currentThread().getName() + "\t 没有可消费的信息");
                break;
            } else {
                System.err.println(Thread.currentThread().getName() + "\t 消费成功");
            }
        }
    }

    public void stop() {
        atomicBoolean.set(false);
    }

    public AtomicReference<T> getAtomicReference() {
        return atomicReference;
    }

    public void setAtomicReference(AtomicReference<T> atomicReference) {
        this.atomicReference = atomicReference;
    }
}