package com.bkc.thread;

public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Wating(), "WaitingThread").start();
        //使用两个Blocked线程，一个获取锁成功，一个呗阻塞
        new Thread(new Blocked(), "BlockedThread-0").start();
        new Thread(new Blocked(), "BlockedThread-1").start();
    }

    static class TimeWaiting implements Runnable {
        @Override public void run() {
            while (true) {
                SleepUtil.second(100);
            }
        }
    }


    static class Wating implements Runnable {

        @Override public void run() {
            while (true) {
                synchronized (Wating.class) {
                    try {
                        Wating.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    static class Blocked implements Runnable {

        @Override public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtil.second(100);
                }
            }
        }
    }
}
