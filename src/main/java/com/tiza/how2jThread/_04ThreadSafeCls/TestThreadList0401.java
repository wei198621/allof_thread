package com.tiza.how2jThread._04ThreadSafeCls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/**
 * Author: tz_wl
 * Date: 2020/10/8 0:16
 * Content:
 *
 * https://how2j.cn/k/thread/thread-thread-safe/703.html
 *
 *
 */
public class TestThreadList0401 {

    //线程不安全         线程安全
    //HashMap          //Hashtable
    //StringBuilder    //StringBuffer
    //ArrayList        //Vector

    // 借助Collections.synchronizedList，可以把ArrayList转换为线程安全的List。
    public static void main(String[] args) {

        //HashMap   public V put(K var1, V var2) {
        //Hashtable    public synchronized V put(K var1, V var2) {
        //new StringBuilder();  public StringBuilder append(String var1) {
        //new StringBuffer();  public synchronized StringBuffer append(String var1) {
        //new ArrayList<>();    public void add(int var1, E var2) {
        // new Vector<>();    //add 实际调用  public synchronized void insertElementAt(E var1, int var2) {

        List<Integer> list1 = new ArrayList<>();
        int count = 10000;
        Thread t = new Thread() {
            public void run() {
                for (int i = 0; i < count; i++) {
                    list1.add(1);
                    System.out.println("add 1  ; size is :"+list1.size()+" ; i is : "+(i+1));
                }
            }
        };
        t.start();

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < count; i++) {
                    if (list1.size() > 1) {
                        list1.remove(1);
                        System.out.println("-------remove  1  ; size is :"+ list1.size()+" ; i is : "+(i+1));
                    }
                }
            }
        };

        t2.start();


        ////等待所有增加线程结束

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // //等待所有减少线程结束

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("total size is : " + list1.size());

    }
}
