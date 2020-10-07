package com.tiza.how2jThread._05Deadlock;

/**
 * Author: tz_wl
 * Date: 2020/10/8 0:32
 * Content:
 */
public class Hero {

    public String name ;
    public float hp ;
    public int damage;

    //回血
    public void recover(){
        hp=hp+1;
    }

    //掉血
    public void hurt(){
        hp=hp-1;
    }

    //袭击英雄
    public void attackHero(Hero h){
        h.hp-= damage;
        System.out.format("%s 正在攻击 %s ,%s 的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if(h.isDead()){
            System.out.println(h.name + "dead .... ");
        }
    }

    //是否死亡
    public  boolean isDead(){
        return 0>= hp? true: false;
    }
}
