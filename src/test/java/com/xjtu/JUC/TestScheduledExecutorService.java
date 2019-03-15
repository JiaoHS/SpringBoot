package com.xjtu.JUC;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @auther coraljiao
 * @date 2019/2/15 14:54
 * @description
 */
public class TestScheduledExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            ScheduledFuture<Integer> future = pool.schedule(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    return num;
                }
            }, 2, TimeUnit.SECONDS);
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
