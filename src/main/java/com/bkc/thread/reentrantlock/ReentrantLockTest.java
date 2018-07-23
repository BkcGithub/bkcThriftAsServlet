package com.bkc.thread.reentrantlock;


import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable{
    public static ReentrantLock lock = new ReentrantLock(true);

    @Override public void run() {
        while (true) {
            try {
                lock.lock();
                System.err.println(Thread.currentThread().getName() + "获取到了锁！");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test, "线程1");
        Thread t2 = new Thread(test, "线程2");
        t1.start();t2.start();
    }
}
