package com.tiza.leo._02threadPool;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Author: tz_wl
 * Date: 2020/10/7 12:56
 * Content:
 */
public class threadPoolPkTest {
    public static void main(String[] args) throws InterruptedException {

        long timeStart = System.currentTimeMillis();
        final ArrayList<Integer> list = new ArrayList<>();
        final Random random = new Random();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for ( int i = 0; i < 10000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        // executorService.awaitTermination(1, TimeUnit.DAYS); //等待线程结束,相当于 threadPkTest 中的  thread.join();
        long timeEnd = System.currentTimeMillis();
        System.out.println("共耗时 " + (timeEnd - timeStart) + "  ms list.size() = " + list.size());


        /*  共耗时 25  ms list.size() = 9790   注释 executorService.awaitTermination(1, TimeUnit.DAYS);*/
        /*  共耗时 29  ms list.size() = 10000       executorService.awaitTermination(1, TimeUnit.DAYS);  */


    }
}
