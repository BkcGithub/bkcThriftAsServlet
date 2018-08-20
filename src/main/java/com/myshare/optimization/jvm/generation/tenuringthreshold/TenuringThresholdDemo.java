package com.myshare.optimization.jvm.generation.tenuringthreshold;

import com.bkc.util.ProcessUtil;
import com.myshare.optimization.jvm.generation.GcDataObject;

import java.util.ArrayList;
import java.util.List;

public class TenuringThresholdDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("ready to start " + ProcessUtil.getProcessID());
        Thread.sleep(10000);
        List<GcDataObject> objects = new ArrayList<>();

        for (int i = 0; i < 52100; i++) {
            objects.add(new GcDataObject(1));
        }
        List<GcDataObject> tmpObject = new ArrayList<>();

        for (int i = 0; i < 10240; i++) {
            tmpObject.add(new GcDataObject(4));
        }
        System.gc();
        Thread.sleep(1000);
        tmpObject.size();
        tmpObject = null;

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 30; i++) {
            GcDataObject toOldObject = new GcDataObject(1024);
            for (int j = 0; i < 16; i++) {
                for (int m = 0; m < 23; m++) {

                    new GcDataObject(1024);
                }

            }
            toOldObject.toString();
            toOldObject = null;

        }

        objects.size();
        long endTime = System.currentTimeMillis();
        System.out.println("execute " + (endTime - beginTime) + "ms");
        Thread.sleep(10000);

    }
}
