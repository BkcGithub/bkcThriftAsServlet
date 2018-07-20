package com.bkc.thread.synchronize;

public class Main {
    public int i = 10;

    synchronized public void operateMain() {
        try {
            i--;
            System.out.println("main print i = " + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
