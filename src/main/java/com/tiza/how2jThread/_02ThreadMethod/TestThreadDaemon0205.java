package com.tiza.how2jThread._02ThreadMethod;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:43
 * Content:
 */
public class TestThreadDaemon0205 {


    public static void main(String[] args) {
        Thread t1=new Thread(){
            public void run(){
                int sec=0;
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了 LOL %d 秒 %n",sec++);
                }
            }
        };
        //t1.setDaemon(true);  //此句执行的时候,t1启动了也不会执行，因为只有一个守护线程，当前进程自动结束
        t1.start();

        /*
        * 守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程。

就好像一个公司有销售部，生产部这些和业务挂钩的部门。
除此之外，还有后勤，行政等这些支持部门。

如果一家公司销售部，生产部都解散了，那么只剩下后勤和行政，那么这家公司也可以解散了。

守护线程就相当于那些支持部门，如果一个进程只剩下守护线程，那么进程就会自动结束。

守护线程通常会被用来做日志，性能统计等工作。
        * */


    }

}
