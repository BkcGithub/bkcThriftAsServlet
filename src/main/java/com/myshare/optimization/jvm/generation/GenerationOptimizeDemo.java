package com.myshare.optimization.jvm.generation;

import com.bkc.thread.mythread.Run;
import com.bkc.util.ProcessUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class GenerationOptimizeDemo {
    static AtomicInteger integer = new AtomicInteger(1);

    static class Task implements Runnable{

        @Override public void run() {
            System.out.println(integer.getAndIncrement());
        }
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < 100; i ++) {
            new Thread(new Task()).start();
        }*/

        String str1 = "bkcbkc";
        test1(str1);

        StringBuffer stringBuffer = new StringBuffer("stringBuffer");
        test2(stringBuffer);

        System.out.println(str1);
        System.out.println(stringBuffer.toString());

        System.out.println(3|4);


    }
    public static void test1(String str1) {

        str1 = new String("12121");
    }
    public static void test2(StringBuffer str2) {
        str2 = new StringBuffer("new StringBuffer");
    }
    /*static ConcurrentLinkedDeque linkedDeque = new ConcurrentLinkedDeque();

    //1. -Xms135M -Xmx135M -Xmn20M -XX:+UseSerialGC
    //then -Xmn30M
    //then -Xmn105M
    //2. -Xms135M -Xmx135M -Xmn20M -XX:+UseSerialGC -XX:SurvivorRatio=10
    public static void main(String[] args) throws Exception {
        linkedDeque.offer(new Object());
        System.out.println("ready to start " + ProcessUtil.getProcessID());
        Thread.sleep(15000);
        List<GcDataObject> oldGenObjects = new ArrayList<>();
        for (int i = 0; i < 51200; i++) {
            oldGenObjects.add(new GcDataObject(2));
        }
        System.gc();
        oldGenObjects.size();
        oldGenObjects = null;
        Thread.sleep(5000);

        List<GcDataObject> tmpObjects = new ArrayList<>();
        for (int i = 0; i < 3200; i++) {
            tmpObjects.add(new GcDataObject(5));
        }
        tmpObjects.size();
        tmpObjects = null;

    }*/

}
