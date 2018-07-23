package com.bkc.thread.waitnotify.waitandnotify;

public class MyThreadWait extends Thread {
    Object lock;

    public MyThreadWait(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始   wait time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束   wait time = " + System.currentTimeMillis());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
