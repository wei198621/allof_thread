package com.tiza.how2jThread._02ThreadMethod;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:25
 * Content:
 * https://how2j.cn/k/thread/thread-methods/354.html#nowhere
 */
public class TestThreadSleep0201 {

    public static void main(String[] args) {
        //匿名类实现
        Thread t1=new Thread(){
            public void run(){
                int seconds =0;
                while (true){
                    try {
                        Thread.sleep(1000);  // 当前线程暂停1秒，其他线程不受影响
                        // sleep 会抛出 interruptedException 中断异常，因为当前线程sleep的时候，有可能会被停止，如被停止则抛出InterruptedException
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了 LOL %d 秒 %n",seconds++);
                }
            }
        };
        t1.start();

        //这块是在主线程中运行的 上面的 Thread.sleep 不影响这块的运行
        //注意不要运行下面的代码，会使得CPU使用率很高
        /*while (true){
            System.out.printf("主线程运行中。。。。。。");
        }*/
    }
}
