package com.tiza.how2jThread._02ThreadMethod;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:41
 * Content:
 */
public class TestThreadYield0204 {


    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6600;
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
        leesin.hp = 4550;
        leesin.damage = 1;


        Thread t1= new Thread(){
            public void run(){

                while(!teemo.isDead()){
                    gareen.attackHeroWithoutSleep(teemo);
                }
            }
        };

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    Thread.yield();           //临时暂停，使得t1可以占用CPU资源
                    //t1  t2 两个线程优先级一致，但是运行到t2,t2,就会主动谦让，休息一下
                    bh.attackHeroWithoutSleep(leesin);
                }
            }
        };

        t1.setPriority(5);
        t2.setPriority(5);
        t1.start();
        t2.start();
    }


    /*
    *
    *
盖伦 正在攻击 提莫 ,提莫 的血变成了 2918
盖伦 正在攻击 提莫 ,提莫 的血变成了 2917
盖伦 正在攻击 提莫 ,提莫 的血变成了 2916
盖伦 正在攻击 提莫 ,提莫 的血变成了 2915
盖伦 正在攻击 提莫 ,提莫 的血变成了 2914
盖伦 正在攻击 提莫 ,提莫 的血变成了 2913
盖伦 正在攻击 提莫 ,提莫 的血变成了 2912
盖伦 正在攻击 提莫 ,提莫 的血变成了 2911
盖伦 正在攻击 提莫 ,提莫 的血变成了 2910
赏金猎人 正在攻击 盲僧 ,盲僧 的血变成了 4547
盖伦 正在攻击 提莫 ,提莫 的血变成了 2909
盖伦 正在攻击 提莫 ,提莫 的血变成了 2908
盖伦 正在攻击 提莫 ,提莫 的血变成了 2907
盖伦 正在攻击 提莫 ,提莫 的血变成了 2906
盖伦 正在攻击 提莫 ,提莫 的血变成了 2905
盖伦 正在攻击 提莫 ,提莫 的血变成了 2904
盖伦 正在攻击 提莫 ,提莫 的血变成了 2903
盖伦 正在攻击 提莫 ,提莫 的血变成了 2902
盖伦 正在攻击 提莫 ,提莫 的血变成了 2901
盖伦 正在攻击 提莫 ,提莫 的血变成了 2900
盖伦 正在攻击 提莫 ,提莫 的血变成了 2899
盖伦 正在攻击 提莫 ,提莫 的血变成了 2898
    *
    * */



}
