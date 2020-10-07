package com.tiza.leo._01threeTypeOfMultithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: tz_wl
 * Date: 2020/10/7 13:46
 * Content:  线程池的使用
 */
public class clsThreadpool01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        /*
        submit   execute 方法的区别
        1.  submit 有返回值  ， execute 没有返回值


         */

        //executorService.execute                     //execute 方法 无返回值
        executorService.submit(new Runnable() {      // submit 返回 Future<?>
            @Override
            public void run() {
                System.out.println(" test threadpool01  ");
            }
        });

       /*
       //jdk 1.8 的lambda 表达式的写法
        executorService.submit(()->{
            System.out.println(" test threadpool 02 ");
        });
        */
        executorService.shutdown();
    }
}
