package com.xjtu.JUC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @auther coraljiao
 * @date 2019/2/15 14:01
 * @description
 */
public class TestThreanPool {
    public static void main(String[] args) throws Exception {
        ThreadPoolDemo tp = new ThreadPoolDemo();
//        //1、创建线程池
//        ExecutorService pool = Executors.newFixedThreadPool(5);//创建固定大小为 5 的线程池
//        //2、为线程池中的线程分配任务
//        for (int i = 0; i < 10; i++) {
//            pool.submit(tp);
//        }
//        //3、关闭线程池
//        pool.shutdown();

        //二.使用Callable方式
        //1、创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);//创建固定大小为 5 的线程池
        List<Future<Integer>> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i < 100; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });
            list.add(future);
        }
        pool.shutdown();

        for (Future<Integer> future : list) {
            System.out.println(future.get());
        }
    }
}

class ThreadPoolDemo implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (number < 100) {
            System.out.println(Thread.currentThread().getName() + " : " + number++);
        }
    }
}
