package com.tiza.how2jThread._03Synchronize;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:54
 * Content:
 */
public class TestThreadWithoutSynchronized0301 {

    public static void main(String[] args) {
        final Hero gareen =new Hero();
        gareen.name="";
        gareen.hp=10000;
        System.out.printf("盖伦的初始血量是 %.0f%n",gareen.hp);

        int count=10000;
        Thread[] addThread=new Thread[count];
        Thread[] reduceThread=new Thread[count];


        //n个线程减少盖伦的hp
        for(int i=0;i<count;i++){
            Thread t =new Thread(){
                public void run(){
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThread[i]=t;
        }

        //n个线程增加盖伦的hp
        for(int i=0;i<count;i++){
            Thread t =new Thread(){
                public void run(){
                    gareen.recover();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThread[i]=t;
        }



        //  不增加  t.join();   先执行谁，后执行谁的差距会很大

        System.out.printf("%d个增加线程 %d 个减少线程  ，盖伦的血量变为 %.0f %n ",count,count,gareen.hp);
        //10000个增加线程 10000 个减少线程  ，盖伦的血量变为 11010   增加线程在前面，减少线程在后面， 到打印的时候，
        // 减少，增加 线程可能 都 没有执行完，由于增加线程执行的多，所以值会大很多
        //
        //10000个增加线程 10000 个减少线程  ，盖伦的血量变为 8491   减少线程在前面，增加线程在后面， 到打印的时候，
        // 减少，增加 线程可能 都 没有执行完，由于减少线程执行的多，所以值会小很多


    }

}
