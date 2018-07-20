package com.bkc.thread.synchronize;

public class MyThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override public void run() {
                Sub sub = new Sub();
                sub.operateSub();
            }
        }).start();
    }
}
