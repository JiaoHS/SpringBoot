package com.xjtu.JUC;

/**
 * @auther coraljiao
 * @date 2019/2/14 22:15
 * @description
 */
public class TestThread8Monitor {
    public static void main(String[] args){
        Thread8MonitorDemo demo=new Thread8MonitorDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.getTwo();
            }
        }).start();
    }
}
class Thread8MonitorDemo{
    public void getOne(){
        System.out.println("one");
    }
    public void getTwo(){
        System.out.println("two");
    }
}
