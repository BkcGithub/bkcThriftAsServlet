package com.bkc.thread.mythread;

public class MyThread extends Thread {
    private int x = 5;

    @Override
    synchronized public void run() {
        super.run();
        x--;
        System.out.println(this.currentThread().getName() + " " + x);
    }
}
