package com.bkc.thread.mythread;

import com.bkc.thread.SleepUtil;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunnerThread");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override public void run() {
            try {
                SleepUtil.second(100);
            } finally {
                System.out.println("DaemonThread finally run");
            }

        }
    }
}
