package com.tiza.how2jThread._01StartThread._0102CreateByThread;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:12
 * Content:
 *
 * https://how2j.cn/k/thread/thread-start/353.html#nowhere
 */
public class TestThread {

    public static void main(String[] args) {


        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
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

        KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread2.start();

        /*packagesss
         * 使用多线程，看到 盖伦攻击提莫的同时   赏金猎人 也在攻击 盲僧
         * 类 killThread 继承 Thread ，重写 run 方法
         * 启动线程办法：  实例化一个KillThread 对象，调用其start方法
         *
         * */
    }
}
