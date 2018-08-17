package com.bkc.thread.dealthread;

public class Main {
    @Override protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        DealThread t1 = new DealThread();
        t1.setUserName("a");

        Thread thread = new Thread(t1);
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.setUserName("b");
        Thread thread1 = new Thread(t1);
        thread1.start();

        ThreadLocal<String> t = new ThreadLocal<>();

        t.set("sss");
    }
}
