package com.wf.util;

/**
 * @author wf
 * @create 2020-05-04 18:34
 * @desc
 **/
public class SnowFlake {
    /**工作机器Id(0-31)*/
    private long workerId;

    /**数据中心Id(0-31)*/
    private long datacenterId;

    /**毫秒内序列(0-4095)*/
    private long sequence = 0L;

    /**上次生成id的时间戳*/
    private long lastTimeStamp = -1L;

    /**开始的时间戳*/
    private final long twepoch = 1288834974657L;

    /**机器id所占的位数*/
    private final long workerIdBits = 5L;

    /**数据中心id所占的位数*/
    private final long datacenterIdBits = 5L;

    /**支持得最大机器Id,结果是31*/
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /**支持得最大数据Id,结果是31*/
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /**序列在Id中占的位数*/
    private final long sequenceBits = 12L;

    /**机器Id向左移12位*/
    private final long workerIdShift = sequenceBits;

    /**数据Id向左移17位*/
    private final long datacenterIdShift = sequenceBits + workerIdBits;

    /**时间戳Id向左移17+5位*/
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    /**生成序列掩码，4095*/
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * 构造函数
     * @param workerId
     * @param datacenterId
     */
    public SnowFlake(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("workId can't be greater than" +
                    "%d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenterId can't be greater than" +
                    "%d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        // 如果当前时间小于上次Id生成的时间戳，说明系统时钟回拨过，
        if (timestamp < lastTimeStamp) {
            throw new RuntimeException(String.format("Clock moved backwards, Refusing to generate" +
                    "id for %d milliseconds", lastTimeStamp - timestamp));
        }
        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastTimeStamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 等待下一毫秒
                timestamp = waitNextMill(lastTimeStamp);
            }
        } else {
            sequence = 0;
        }
        // 上次生成Id的时间戳
        lastTimeStamp = timestamp;

        // 移位并通或运算生成64位的序列
        return ((timestamp - twepoch) << timestampLeftShift)
                |  (datacenterId << datacenterIdShift)
                |  (workerId << workerIdShift)
                |  sequence;
    }

    protected long waitNextMill(long lastTimeStamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimeStamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SnowFlake snowFlake = new SnowFlake(1, 1);
        for (int i = 0; i < 10; i++) {
            System.out.println(String.valueOf(snowFlake.nextId()));
        }
    }
}
