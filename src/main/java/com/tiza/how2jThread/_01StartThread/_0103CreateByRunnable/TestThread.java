package com.tiza.how2jThread._01StartThread._0103CreateByRunnable;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:16
 * Content:
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


        Battle battle1=new Battle(gareen,teemo);
        new Thread(battle1).start();

        Battle battle2 =new Battle(bh,leesin);
        new Thread(battle2).start();

        /*
         * 创建battle 类 ，实现 Runnable  接口
         * 启动时候需要将 （实现 Runnable  接口的）battle类， 作为参数 创建一个线程，并启动
         *
         * */
    }
}
