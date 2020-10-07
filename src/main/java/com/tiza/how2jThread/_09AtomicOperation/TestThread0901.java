package com.tiza.how2jThread._09AtomicOperation;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: tz_wl
 * Date: 2020/10/8 1:17
 * Content:
 */
public class TestThread0901 {

    public static void main(String[] args) {
        AtomicInteger atomicInt =new AtomicInteger();
        int i=atomicInt.decrementAndGet();
        int j =atomicInt.incrementAndGet();
        int k=atomicInt.addAndGet(3);
    }
}
