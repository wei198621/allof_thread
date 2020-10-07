package com.tiza.how2jThread._03Synchronize;

/**
 * Author: tz_wl
 * Date: 2020/10/8 0:13
 * Content:
 */
public class TestThreadWithSynchronized_HeroSyncMethord_0306 {

    public static void main(String[] args) {
        final HeroSynchronized gareen = new HeroSynchronized();  // 注意此处用的是synchronized版本的Hero
        gareen.name = "盖伦";
        gareen.hp = 10000;
        System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);

        int count = 10000;
        Thread[] addThread = new Thread[count];
        Thread[] reduceThread = new Thread[count];

        for (int i = 0; i < count; i++) {
            Thread t = new Thread() {
                public void run() {
                    //任何线程要修改hp的值，必须先占用someObject
                    gareen.recover();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThread[i] = t;
        }

        for (int i = 0; i < count; i++) {
            Thread t = new Thread() {
                public void run() {
                    //使用gareen作为synchronized
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThread[i] = t;
        }


        ////等待所有增加线程结束
        for (Thread t : addThread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // //等待所有减少线程结束
        for (Thread t : reduceThread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.printf("%d个增加线程 %d 个减少线程  ，盖伦的血量变为 %.0f %n ", count, count, gareen.hp);
        //10000个增加线程 10000 个减少线程  ，盖伦的血量变为 10000



    }
}
