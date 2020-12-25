package com.wah.commons.utils;

public class SnowFlakeUtils{

    //起始时间戳 1992-08-29 20:00:00 GMT+0800
    private final long twepoch      = 715089600000L;
    //机器号长度
    private final long workerIdBits = 5L;
    //中心号长度
    private final long centerIdBits = 5L;
    //最大机器号 31
    private final long maxWorkerId = ~(-1L << workerIdBits);
    //最大中心号 31
    private final long maxCenterId = ~(-1L << centerIdBits);
    //序列号长度
    private final long sequenceBits = 12L;

    private final long workerIdShift      = sequenceBits;
    private final long centerIdShift      = sequenceBits + workerIdBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits + centerIdBits;
    private final long sequenceMask       = ~(-1L << sequenceBits);

    //序列号
    private long sequence      = 0L;
    //最新的时间戳
    private long lastTimestamp = -1L;

    private long workerId;
    private long centerId;

    public SnowFlakeUtils(long centerId, long workerId){
        AssertUtils.between(0, maxCenterId, centerId, "合法的中心号为 : [0 ~ {0}]");
        AssertUtils.between(0, maxWorkerId, workerId, "合法的机器号为 : [0 ~ {0}]");

        this.centerId = centerId;
        this.workerId = workerId;
    }

    public synchronized long getId(){
        long timestamp = timeGen();

        if(timestamp < lastTimestamp){
            throw new IllegalArgumentException("时间回拨,生成ID失败");
        }

        if(timestamp == lastTimestamp){
            sequence = (sequence + 1) & sequenceMask;

            if(sequence == 0){
                timestamp = tilNextMillis(lastTimestamp);
            }
        }else{
            sequence = 0;
        }

        //更新时间戳
        lastTimestamp = timestamp;

        //计算
        long id = ((timestamp - twepoch) << timestampLeftShift)
                    | (centerId << centerIdShift)
                    | (workerId << workerIdShift)
                    | sequence;

        return id;
    }

    public String getIdAsString(){
        long id = getId();

        return Long.toString(id);
    }

    private long tilNextMillis(long lastTimestamp){
        long timestamp = timeGen();

        while(timestamp <= lastTimestamp){
            timestamp = timeGen();
        }

        return timestamp;
    }

    private long timeGen(){
        return System.currentTimeMillis();
    }

    public long getWorkerId(){
        return this.workerId;
    }

    public long getCenterId(){
        return this.centerId;
    }
}
