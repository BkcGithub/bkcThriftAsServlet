package com.bkc.thread.threadMXBean;

import sun.misc.Unsafe;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Mutithread {
    public static void main(String[] args) {
        //获取java线程管理mxbean
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = bean.dumpAllThreads(false, false);

        for (ThreadInfo info : threadInfos) {
            System.out.println(info.getThreadId() + "--" + info.getThreadName());
        }

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        System.out.println(atomicBoolean.compareAndSet(false, true));

        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<Object>(10);
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

    }
}
