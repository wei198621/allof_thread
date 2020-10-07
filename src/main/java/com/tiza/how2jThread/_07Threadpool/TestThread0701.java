package com.tiza.how2jThread._07Threadpool;

/**
 * Author: tz_wl
 * Date: 2020/10/8 1:00
 * Content:
 *
 * https://how2j.cn/k/thread/thread-threadpool/357.html#nowhere
 */
public class TestThread0701 {

    public static void main(String[] args) {
        ThreadPool pool=new ThreadPool();
        for(int i=0;i<5;i++){
            Runnable task =new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
                }
            };
            pool.add(task);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
