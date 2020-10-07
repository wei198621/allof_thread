package com.tiza.how2jThread._01StartThread._0101WithoutThread;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:02
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

        //盖伦攻击提莫
        while(!teemo.isDead()){
            gareen.attachHero(teemo);
        }

        //赏金猎人攻击盲僧
        while (!leesin.isDead()){
            bh.attachHero(leesin);
        }
/*
        此处代码演示的是不使用多线程的情况：
        只有在盖伦杀掉提莫后，赏金猎人才开始杀盲僧*/
    }
}
