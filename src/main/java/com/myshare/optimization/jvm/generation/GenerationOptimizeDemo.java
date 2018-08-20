package com.myshare.optimization.jvm.generation;

import com.bkc.util.ProcessUtil;

import java.util.ArrayList;
import java.util.List;

public class GenerationOptimizeDemo {
    //1. -Xms135M -Xmx135M -Xmn20M -XX:+UseSerialGC
    //then -Xmn30M
    //then -Xmn105M
    //2. -Xms135M -Xmx135M -Xmn20M -XX:+UseSerialGC -XX:SurvivorRatio=10
    public static void main(String[] args) throws Exception {
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

    }

}
