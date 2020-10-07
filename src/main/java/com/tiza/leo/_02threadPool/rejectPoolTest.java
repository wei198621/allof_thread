package com.tiza.leo._02threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author: tz_wl
 * Date: 2020/10/7 15:19
 * Content:
 * https://www.bilibili.com/video/BV1rJ41117XR?t=10
 * 70~85 分钟
 *
 */
public class rejectPoolTest implements Runnable {


    @Override
    public void run() {
        System.out.println(System.currentTimeMillis()+ "Thread ID: "+ Thread.currentThread().getId());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //test01();  //报错  ，值执行完maxPool就报错跳出异常  （默认的拒绝策略）
        test02();  //不报错  ，执行到结束
    }

    private static void test01() {
        rejectPoolTest task = new rejectPoolTest();
        ExecutorService es = new ThreadPoolExecutor(
                5,
                7,
                0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory());

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            es.submit(task);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test02() {
        rejectPoolTest task = new rejectPoolTest();
        ExecutorService es = new ThreadPoolExecutor(
                5,
                7,
                0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                        System.out.println("已经满了");
                    }
                });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            es.submit(task);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
