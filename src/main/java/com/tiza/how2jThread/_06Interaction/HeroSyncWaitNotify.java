package com.tiza.how2jThread._06Interaction;

/**
 * Author: tz_wl
 * Date: 2020/10/8 0:49
 * Content:
 */
public class HeroSyncWaitNotify {

    public String name;
    public float hp;
    public int damage;

    //回血
    //直接在方法前加上修饰符synchronized
    //其所对应的同步对象，就是this
    //和hurt方法达到的效果一样
    public synchronized void recover() {
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
        this.notify();
    }

    //掉血
    public synchronized void hurt() {
        if(hp==1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp=hp-1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);

    }

    //袭击英雄
    public void attackHero(HeroSyncWaitNotify h) {
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s ,%s 的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead()) {
            System.out.println(h.name + "dead .... ");
        }
    }

    //是否死亡
    public boolean isDead() {
        return 0 >= hp ? true : false;
    }

}
