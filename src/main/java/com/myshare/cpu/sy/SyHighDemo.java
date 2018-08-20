package com.myshare.cpu.sy;

import java.util.Random;

public class SyHighDemo {

    private static int threadCount = 100;
    private Random random = new Random();

    private Object[] locks;

    public void runTest() throws Exception {
        locks = new Object[threadCount];

        for (int i = 0; i < threadCount; i++) {
            locks[i] = new Object();
        }

        for (int i = 0; i < threadCount; i++) {
            new Thread(new ATask(i)).start();
            new Thread(new BTask(i)).start();
        }
    }

    class ATask implements Runnable {

        private Object lockObject = null;

        public ATask(int i) {
            lockObject = locks[i];
        }

        @Override public void run() {
            while (true) {
                try {
                    synchronized (lockObject) {
                        lockObject.wait(random.nextInt(10));
                    }
                } catch (Exception e) {

                }
            }
        }
    }


    class BTask implements Runnable {

        private Object lockObject = null;

        public BTask(int i) {
            lockObject = locks[i];
        }

        @Override public void run() {
            while (true) {
                synchronized (lockObject) {
                    lockObject.notifyAll();
                }
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
