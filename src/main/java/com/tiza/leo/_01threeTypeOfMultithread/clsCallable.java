package com.tiza.leo._01threeTypeOfMultithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Author: tz_wl
 * Date: 2020/10/7 12:31
 * Content:
 *
 * https://www.bilibili.com/video/BV1rJ41117XR?t=10
 * 13~20 分钟
 */
public class clsCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "源码学院 monkey 老师创作的视频 leo study";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new clsCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
