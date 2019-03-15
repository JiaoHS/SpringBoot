package com.xjtu.JUC;

import org.apache.logging.log4j.message.ReusableMessage;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @auther coraljiao
 * @date 2019/2/15 15:11
 * @description
 */
public class TestForkJoinPool {
    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinPoolCal(0L, 10000000000L);

        System.out.println(pool.invoke(task));
        Instant end = Instant.now();
        System.out.println("耗费时间为："+Duration.between(start,end).toMillis());//1759ms
    }
    @Test
    public void test01(){
        Instant start = Instant.now();
        long sum=0L;
        for (long i = 0; i < 10000000000L; i++) {
            sum+=i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为："+Duration.between(start,end).toMillis());//2935ms
    }
    @Test
    public void test02(){
        Instant start = Instant.now();
      long sum=LongStream.rangeClosed(0L,10000000000L).parallel().reduce(0L,Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为："+Duration.between(start,end).toMillis());//1086ms
    }
}

class ForkJoinPoolCal extends RecursiveTask<Long> {
    private long start;
    private long end;

    private static final long THURSHOLD = 10000L;//临界值

    public ForkJoinPoolCal(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THURSHOLD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinPoolCal left = new ForkJoinPoolCal(start, middle);
            left.fork();

            ForkJoinPoolCal right = new ForkJoinPoolCal(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
