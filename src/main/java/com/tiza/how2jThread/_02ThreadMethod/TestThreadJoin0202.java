package com.tiza.how2jThread._02ThreadMethod;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:27
 * Content:
 */
public class TestThreadJoin0202 {


    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        Thread t1=new Thread(){
            public void run(){
                while (!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };
        t1.start();

        //可以比较 没有t1.join 和有t1.join 的运行效果
        //会观察到盖伦把提莫杀掉后，才运行t2线程
        try {
            t1.join();
            // t1 线程加入到main线程中，只有t1运行结束，才会继续往下走
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread t2=new Thread(){
            public void run(){
                while (!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();

    }

}
