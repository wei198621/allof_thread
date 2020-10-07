package com.tiza.how2jThread._01StartThread._0104CreateByAnonymousCls;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:18
 * Content:
 *
 * https://how2j.cn/k/thread/thread-start/353.html#nowhere
 *
 */
public class TestThread {

    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        //************************************************************

        Thread t1 = new Thread() {
            public void run() {
                //teemo =new Hero(); // cant assign a value to final variable 'teemo';
                //匿名类中用到外部局部变量teemo,必须声明为final
                //JDK 1.7 以后 ，默认final ,不必添加final 的了
                while (!teemo.isDead()) {
                    gareen.attachHero(teemo);
                }
            }
        };
        t1.start();


        //************************************************************
        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    bh.attachHero(leesin);
                }
            }
        };
        t2.start();
        //************************************************************

    }
}
