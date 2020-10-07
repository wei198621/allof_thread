package com.tiza.how2jThread._07Threadpool;

/**
 * Author: tz_wl
 * Date: 2020/10/8 1:02
 * Content:
 */
public class TestThread0702 {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        int sleep = 1000;

        while (true) {
            pool.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(sleep);
                sleep = sleep > 100 ? sleep - 100 : sleep;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
