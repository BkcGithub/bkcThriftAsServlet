package com.bkc.thread.waitnotify;

public class Test2 {
    public static void main(String[] args) {
        String lock = new String();
        System.out.println("sync 上面");
        synchronized (lock) {
            System.out.println("sync 第一行");
            try {
                lock.wait();
                System.out.println("wait 下面");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sync 下面");
    }
}
