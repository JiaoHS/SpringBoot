package com.xjtu.JUC;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther coraljiao
 * @date 2019/2/14 21:33
 * @description
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        AlternateDemo alternateDemo=new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    alternateDemo.loopA(i);
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    alternateDemo.loopB(i);
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    alternateDemo.loopC(i);
                }
            }
        },"C").start();
    }
}

class AlternateDemo {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int totalLoop) {
        lock.lock();
        try {
            //1、判断
            if (number != 1) {
                condition1.await();
            }
            //2、打印
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            //3、唤醒
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop) {
        lock.lock();
        try {
            //1、判断
            if (number != 2) {
                condition2.await();
            }
            //2、打印
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            //3、唤醒
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop) {
        lock.lock();
        try {
            //1、判断
            if (number != 3) {
                condition3.await();
            }
            //2、打印
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            //3、唤醒
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
