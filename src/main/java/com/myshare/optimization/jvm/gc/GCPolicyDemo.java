package com.myshare.optimization.jvm.gc;

import com.bkc.util.ProcessUtil;

import java.util.ArrayList;
import java.util.List;

public class GCPolicyDemo {
    //-Xms680M -Xmx680M -Xmn80M -XX:+UseConcMarkSweepGC -XX:+PrintGCApplicationStoppedTime -XX:+UseCMSCompactAtFullCollection -XX:CMSMaxAbortablePrecleanTime=5
    //-Xms680M -Xmx680M -Xmn80M –XX:+UseParallelGC –XX:+PrintGCApplicationStoppedTime
    public static void main(String[] args) throws Exception {
        System.out.println("ready to start " + ProcessUtil.getProcessID());
        Thread.sleep(10000);

        List<GCPolicyDataObject> cacheObjects = new ArrayList<>();

        for (int i = 0; i < 2048; i++) {
            cacheObjects.add(new GCPolicyDataObject(100));
        }
        System.gc();
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println("round " + (i + 1));
            for (int j = 0; j < 5; j++) {
                System.out.println("put 64M Objects");
                List<GCPolicyDataObject> tmpObjects = new ArrayList<>();
                for (int m = 0; m < 1024; m++) {
                    tmpObjects.add(new GCPolicyDataObject(64));
                }
                tmpObjects = null;
            }
        }
        cacheObjects.size();
        cacheObjects = null;

    }
}
