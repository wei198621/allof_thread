package com.tiza.leo._02threadPool;

import java.util.ArrayList;
import java.util.Random;

/**
 * Author: tz_wl
 * Date: 2020/10/7 12:56
 * Content:
 *
 * https://www.bilibili.com/video/BV1rJ41117XR?t=10
 * 25~30 min
 *
 */
public class threadPkTest {
    public static void main(String[] args) throws InterruptedException {

        long timeStart = System.currentTimeMillis();
        final ArrayList<Integer> list = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
            thread.start();
            thread.join();     //join  等待10000个线程执行完成后，再往下执行 ，没有join就不等待
            System.out.println("i is : " + i);
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println("共耗时 " + (timeEnd - timeStart) + "  ms list.size() = " + list.size());


        /* 启用   thread.join(); 共耗时 2323  ms  list.size() = 10000  */
        /* 注释   //thread.join(); 共耗时 1423  ms  list.size() = 9096  */


    }
}
