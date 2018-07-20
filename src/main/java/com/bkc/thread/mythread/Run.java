package com.bkc.thread.mythread;

public class Run {
    public static void main(String[] args) {
        /*MyThread myThread = new MyThread();

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(myThread, "A" + i);
            t.start();
        }*/
        new Thread(new MyThread2()).start();

        StringBuffer stringBuffer= new StringBuffer();
        stringBuffer.append("1");
        stringBuffer.insert(1,"1");
    }
}
