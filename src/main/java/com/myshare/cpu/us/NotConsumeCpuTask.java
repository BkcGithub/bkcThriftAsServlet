package com.myshare.cpu.us;

public class NotConsumeCpuTask implements Runnable{

    @Override public void run() {
        while (true) {
            try {
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
