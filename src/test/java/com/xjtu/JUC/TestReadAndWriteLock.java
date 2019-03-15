package com.xjtu.JUC;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther coraljiao
 * @date 2019/2/14 22:01
 * @description
 */
public class TestReadAndWriteLock {
    public static void main(String[] args) {
        final ReadAndWriteLock readWriteLock = new ReadAndWriteLock();
        //一个线程写
        new Thread(new Runnable() {
            @Override
            public void run() {
                readWriteLock.setT((int) (Math.random() * 101));
            }
        }, "Write").start();
        //100个线程读
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLock.get();
                }
            }).start();
        }
    }
}

class ReadAndWriteLock {
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        lock.readLock().lock();//上锁

        try {
            System.out.println(Thread.currentThread().getName() + ":" + number);
        } finally {
            lock.readLock().unlock();//释放锁
        }
    }

    public void setT(int number) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
