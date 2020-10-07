package com.tiza.leo._01threeTypeOfMultithread;

/**
 * Author: tz_wl
 * Date: 2020/10/7 12:09
 * Content:
 */
public class clsRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(" 源码学院 monkey 老师  -- 02 Runnable  ");
    }

    public static void main(String[] args) {
        new clsRunnable().run();
        //new Thread(new clsRunnable()).start();
    }
}
