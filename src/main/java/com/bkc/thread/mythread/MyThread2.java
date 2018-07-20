package com.bkc.thread.mythread;

public class MyThread2 implements Runnable {


    @Override public void run() {
        int i = 0;

        long time1 = System.currentTimeMillis();
        for (int k = 0; k < 500000; k++) {
            Thread.yield();
            i++;
        }
        long time2 = System.currentTimeMillis();

        System.out.println(time2 - time1);
    }
}
