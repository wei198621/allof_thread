package com.tiza.how2jThread._02ThreadMethod;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:34
 * Content:
 */
public class TestThreadPriority0203 {

    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 1;


        Thread t1= new Thread(){
            public void run(){
                while(!teemo.isDead()){
                    gareen.attackHeroWithoutSleep(teemo);    //attackHeroWithoutSleep 没有sleep
                }
            }
        };

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHeroWithoutSleep(leesin);      //attackHeroWithoutSleep 没有sleep
                }
            }
        };

        //比较设置优先级，不设置优先级的启动顺序    ,更多的资源被t1占据  ，t1 优先执行
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();

    }
}
