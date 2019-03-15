package com.xjtu.JUC;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther coraljiao
 * @date 2019/1/27 11:20
 * @description
 */
public class JUCTest {
    @Test
    public void test01() {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();//线程1修改flag的值
        //主线程main while循环判断
        while (true) {
            if (td.isFlag()) {
                System.out.println("----------------------------");
                break;
            }
        }
        //这么运行程序一直while循环无法结束
        //两个线程共享数据 private boolean flag = false;  两个线程一起读取flag的值  一个线程修改flag的值 另一个还是读取之前的值
        //也就是内存可见性的问题
        //解决的方法：1、锁同步synchronize但是容易造成阻塞
//        while (true) {
//            synchronized (td){
//                if (td.isFlag()) {
//                    System.out.println("----------------------------");
//                    break;
//                }
//            }
//        }
        //volatile关键字，  当多个线程操作共享数据时，可以保证内存中的数据时可见的
        //原理就是底层使用的内存栅栏，时时刻刻的刷新内存（主存）中的数据，它的操作就是在主存中完成的，相对的效率低，但是比锁的效率高
    }
}

class ThreadDemo implements Runnable {
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

