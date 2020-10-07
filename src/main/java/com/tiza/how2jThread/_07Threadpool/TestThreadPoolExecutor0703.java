package com.tiza.how2jThread._07Threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author: tz_wl
 * Date: 2020/10/8 1:04
 * Content:
 *
 * https://how2j.cn/k/thread/thread-threadpool/357.html#nowhere
 */
public class TestThreadPoolExecutor0703 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        });
    }
}
