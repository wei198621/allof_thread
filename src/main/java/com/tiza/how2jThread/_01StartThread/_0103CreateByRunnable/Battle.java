package com.tiza.how2jThread._01StartThread._0103CreateByRunnable;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:15
 * Content:
 */
public class Battle implements Runnable {

    private Hero h1;
    private Hero h2;
    public Battle(Hero h1,Hero h2){
        this.h1=h1;
        this.h2 = h2;
    }


    /**
     *@Description:
     * 实现了Runnable接口，直接调用run方法，
     * 不会启动一个新线程，必须借助线程对象的start方法，start方法会调用的run方法
     *@Param:
     *@return:
     *@date: 2020/4/17
     */
    @Override
    public void run() {
        while (!h2.isDead()){
            h1.attachHero(h2);
        }
    }
}
