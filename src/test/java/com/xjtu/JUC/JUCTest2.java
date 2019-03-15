package com.xjtu.JUC;

import org.junit.Test;
import tk.mybatis.mapper.common.example.SelectOneByExampleMapper;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther coraljiao
 * @date 2019/1/27 15:20
 * @description
 */

public class JUCTest2 {
    public static void main(String[] args) {
//        ThreadDemo2 threadDemo2 = new ThreadDemo2();
//        for (int i = 0; i < 10; i++) {
//            new Thread(threadDemo2).start();
//        }
//        Map<String,String> map=new ConcurrentHashMap<>();
//        final CompareAndSwap compareAndSwap = new CompareAndSwap();
//        for (int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    int expectedValue = compareAndSwap.get();
//                    boolean b = compareAndSwap.compareAndSet(expectedValue, (int) Math.random() * 101);
//                    System.out.println(b);
//                }
//            }).start();
//        }

//        HelloThread helloThread = new HelloThread();
//        for (int i = 0; i < 10; i++) {
//            new Thread(helloThread).start();
//        }

        //闭锁倒计时，等于零的时候开始执行等待主线程
//        final CountDownLatch latch = new CountDownLatch(5);
//        LatchDemo ld = new LatchDemo(latch);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 5; i++) {
//            new Thread(ld).start();
//        }
//
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println("耗费时间为：" + (end - start));

//        CallableDemo demo = new CallableDemo();
//        //执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果，FutureTask是Future的实现类
//        FutureTask<Integer> result = new FutureTask<>(demo);
//        new Thread(result).start();
//        //接收线程运算后的结果
//        try {
//            //当new Thread(result).start();执行完后 才会执行result.get();  所以FutureTask也可用于闭锁
//            Integer integer = result.get();
//            System.out.println(integer);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        LockDemo lockDemo = new LockDemo();
//
//        new Thread(lockDemo, "一号窗口").start();
//        new Thread(lockDemo, "二号窗口").start();
//        new Thread(lockDemo, "三号窗口").start();

        //生产者和消费者
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(productor, "生产者A").start();
        new Thread(consumer, "消费者B").start();
        new Thread(productor, "生产者C").start();
        new Thread(consumer, "消费者D").start();
    }
}

class ThreadDemo2 implements Runnable {
    //private int serialNumber = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getSerialNumber());
    }

    public int getSerialNumber() {
        return atomicInteger.getAndIncrement();
    }
}

class CompareAndSwap {
    private int value;//内存值

    //获取内存值
    public synchronized int get() {
        return value;
    }

    //比较
    public synchronized int CompareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            this.value = newValue;
        }
        return oldValue;
    }

    //设置
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == CompareAndSwap(expectedValue, newValue);
    }
}

class HelloThread implements Runnable {
    //Collections包装类将集合转化为安全集合
//    private static List<String> list=Collections.synchronizedList(new ArrayList<>());
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("aa");
        list.add("bb");
        list.add("cc");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            //Collections.synchronizedList(new ArrayList<>()); 直接add会报错java.util.ConcurrentModificationException
            list.add("dd");
            // private static CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();就解决问题
        }
    }
}

class LatchDemo implements Runnable {
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }
    }
}

class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}

class LockDemo implements Runnable {
    private int tickt = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "得到了锁");
                if (tickt > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {

                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票：" + --tickt);
                }
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放了锁");
                lock.unlock();
            }
        }
    }
}

////店员
//class Clerk {
//    private int product = 0;
//    //存在共享数据，需要用synchronized修饰
//    //进货
//    public synchronized void get() {
//        while (product >= 1) {
//            System.out.println("产品已满");
//
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//
//            }
//        }
////        else {
////            System.out.println(Thread.currentThread().getName() + " : " + ++product);
////            this.notifyAll();//唤醒
////        }
//        System.out.println(Thread.currentThread().getName() + " : " + ++product);
//        this.notifyAll();//唤醒
//    }
//
//    //出货
//    public synchronized void sale() {
//        while (product <= 0) {
//            System.out.println("缺货！");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//
//            }
//        }
////        else {
////            System.out.println(Thread.currentThread().getName() + " : " + --product);
////            this.notifyAll();
////        }
//        System.out.println(Thread.currentThread().getName() + " : " + --product);
//        this.notifyAll();
//    }
//}
////生产者
//class Productor implements Runnable{
//    private Clerk clerk;
//
//    public Productor(Clerk clerk){
//        this.clerk=clerk;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            clerk.get();
//        }
//    }
//}
////消费者
//class Consumer implements Runnable{
//    private Clerk clerk;
//
//    public Consumer(Clerk clerk){
//        this.clerk=clerk;
//    }
//    @Override
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            clerk.sale();
//        }
//    }
//}

//店员
class Clerk {
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //进货
    public void get() {
        try {
            lock.lock();
            while (product >= 1) {
                System.out.println("产品已满");

                try {
//                    this.wait();
                    condition.await();
                } catch (InterruptedException e) {

                }
            }
//        else {
//            System.out.println(Thread.currentThread().getName() + " : " + ++product);
//            this.notifyAll();//唤醒
//        }
            System.out.println(Thread.currentThread().getName() + " : " + ++product);
//            this.notifyAll();//唤醒
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //出货
    public void sale() {
        try {
            lock.lock();
            while (product <= 0) {
                System.out.println("缺货！");
                try {
                    condition.await();
                } catch (InterruptedException e) {

                }
            }
//        else {
//            System.out.println(Thread.currentThread().getName() + " : " + --product);
//            this.notifyAll();
//        }
            System.out.println(Thread.currentThread().getName() + " : " + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

//生产者
class Productor implements Runnable {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

//消费者
class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}