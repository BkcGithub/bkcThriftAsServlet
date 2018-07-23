package com.bkc.thread.waitnotify.waitandnotify;

public class MyThreadNotify extends Thread {
    Object lock;

    public MyThreadNotify(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始   notify time = " + System.currentTimeMillis());
                lock.notify();
                System.out.println("结束   notify time = " + System.currentTimeMillis());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
