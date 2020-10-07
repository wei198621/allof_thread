package com.tiza.how2jThread._01StartThread._0102CreateByThread;

/**
 * Author: tz_wl
 * Date: 2020/10/7 23:11
 * Content:
 */
public class KillThread extends Thread  {


    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1,Hero h2){
        this.h1=h1;
        this.h2 =h2;
    }

    public void run(){
        while(!h2.isDead()){
            h1.attachHero(h2);
        }
    }
}
