package com.tiza.leo._01threeTypeOfMultithread;

/**
 * Author: tz_wl
 * Date: 2020/10/7 11:45
 * Content:
 * https://www.bilibili.com/video/BV1rJ41117XR?t=10
 */
public class clsThread extends Thread {

    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("源码学院 monkey 老师  -- 01 Thread ");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        //new clsThread().run();   //方法级别的调用
        new clsThread().start(); //start 方法启动线程
    }
}
