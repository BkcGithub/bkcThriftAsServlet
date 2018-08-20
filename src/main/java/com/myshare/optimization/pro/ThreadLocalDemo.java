package com.myshare.optimization.pro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
    public static void main(String[] args) throws Exception {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        demo.run();
    }

    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new MyTask());
        System.gc();
    }

    class MyTask implements Runnable {

        @Override
        public void run() {
            ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();
            threadLocal.set(new byte[1024 * 1024 * 30]);
        }
    }

}
