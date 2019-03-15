package com.xjtu.mapper;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther coraljiao
 * @date 2019/1/24 09:29
 * @description
 */
public class ThreadTest {
    @Test
    public void test01() {
//        Thread t1 = new Thread1();
//        Thread t2 = new Thread(new Thread2());
//        Thread t3=new Thread(()->{
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Java技术栈");
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//        System.out.println(t1.getName());
//        System.out.println(t2.getName());
//        String s="aa";
//        s.equals("bb");
//        Map<String,String> map=new ConcurrentHashMap<>();
//        Map<String,String> map2=new HashMap<>();
//        map2.put("xjtu","hello");
//        map2.put("xjtu","hello2");
//        for (Map.Entry<String, String> entry : map2.entrySet()) {
//            System.out.println(entry.getValue());
//        }

        int number = -4;
        //原始数二进制
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);
        number = number >>> 1;
        //无符号右移一位
        printInfo(number);

//        HashSet
    }

    static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}


class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("extends Thread...");
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("implements Thread...");
    }
}
