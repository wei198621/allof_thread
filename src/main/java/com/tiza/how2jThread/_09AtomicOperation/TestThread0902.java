package com.tiza.how2jThread._09AtomicOperation;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: tz_wl
 * Date: 2020/10/8 1:19
 * Content:
 *
 * https://how2j.cn/k/thread/thread-atomic-access/683.html
 *
 * JDK6 以后，新增加了一个包java.util.concurrent.atomic，里面有各种原子类，比如AtomicInteger。
 而AtomicInteger提供了各种自增，自减等方法，这些方法都是原子性的。 换句话说，自增方法 incrementAndGet 是线程安全的，同一个时间，只有一个线程可以调用这个方法。
 *
 */
public class TestThread0902 {

    private static int value=0;
    private static AtomicInteger atomicInt =new AtomicInteger();

    ///    分别使用基本变量的非原子性的++运算符和 原子性的AtomicInteger对象的 incrementAndGet 来进行多线程测试。
    public static void main(String[] args) {
        int number=100000;
        Thread[] ts1=new Thread[number];
        for(int i=0;i<number;i++){
            Thread t=new Thread(){
                public void run(){
                    value++;
                }
            };
            t.start();
            ts1[i]=t;
        }

        //等待这些线程全部结束
        for (Thread t : ts1) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.printf("%d个线程进行value++后，value的值变成:%d%n", number,value);

        Thread[] ts2 = new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread t =new Thread(){
                public void run(){
                    atomicInt.incrementAndGet();
                }
            };
            t.start();
            ts2[i] = t;
        }

        //等待这些线程全部结束
        for (Thread t : ts2) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行atomicValue.incrementAndGet();后，atomicValue的值变成:%d%n", number,atomicInt.intValue());
    }
}
