package com.bkc.thread.waitnotify.waitandnotify;

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        MyThreadWait wait = new MyThreadWait(lock);

        wait.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyThreadNotify notify = new MyThreadNotify(lock);
        notify.start();

    }
}
