package com.bkc.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile {
    public static AtomicInteger count = new AtomicInteger(0);

    public synchronized void cuntAdd() {
        count.addAndGet(1);
    }

    public static void main(String[] args) {
        TestVolatile volitile = new TestVolatile();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int k = 0; k < 100; k++) {
                    volitile.cuntAdd();
                }
                System.out.println(count + " ");
            }).start();
        }
    }
}
