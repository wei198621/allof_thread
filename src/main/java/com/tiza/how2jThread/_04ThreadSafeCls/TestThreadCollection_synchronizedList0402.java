package com.tiza.how2jThread._04ThreadSafeCls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/10/8 0:23
 * Content:
 */
public class TestThreadCollection_synchronizedList0402 {


    //线程不安全         线程安全
    //HashMap          //Hashtable
    //StringBuilder    //StringBuffer
    //ArrayList        //Vector

    // 借助Collections.synchronizedList，可以把ArrayList转换为线程安全的List。
    public static void main(String[] args) {
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = Collections.synchronizedList(list0);  //貌似没有效果

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
