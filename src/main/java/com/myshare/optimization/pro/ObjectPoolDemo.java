package com.myshare.optimization.pro;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

//-Xms128M -Xmx128M -Xmn64M
public class ObjectPoolDemo {
    private static int executeTimes = 10;
    private static int maxFactor = 10;
    private static int threadCount = 10;
    private static final int NOTUSE_OBJECTPOOL = 1;
    private static final int USE_OBJECTPOOL = 1;
    private static int runMode = 1;
    private static CountDownLatch latch = null;

    public static void main(String[] args) throws Exception {
        Thread.sleep(2000);
        long beginTime = System.currentTimeMillis();
        Task task = new Task();
        for (int i = 0; i < executeTimes; i++) {
            System.out.println("round " + (i + 1));
            latch = new CountDownLatch(threadCount);
            for (int j = 0; j < threadCount; j++) {
                new Thread(task).start();
            }
            latch.await();
        }
        long endTime = System.currentTimeMillis();

        System.out.println(
            "Execute summary: Round(" + executeTimes + ") Thread PerRound(100) Object Factor(" + maxFactor
                + ") Execute Time(" + (endTime - beginTime) + "ms)");
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            for (int j = 0; j < maxFactor; j++) {
                if (runMode == USE_OBJECTPOOL) {
                    BigObjectPool.getInstance().getBigObject(j);
                } else {
                    new BigObject(j);
                }
            }
            latch.countDown();
        }
    }


    static class BigObjectPool {
        private static final BigObjectPool self = new BigObjectPool();
        private final Map<Integer, BigObjectPool> cacheObjects = new HashMap<>();

        private BigObjectPool() {

        }

        public static BigObjectPool getInstance() {
            return self;
        }

        public BigObjectPool getBigObject(int factor) {
            if (cacheObjects.containsKey(factor)) {
                return cacheObjects.get(factor);
            } else {
                BigObjectPool objectPool = new BigObjectPool();
                cacheObjects.put(factor, objectPool);
                return objectPool;
            }
        }
    }


    static class BigObject {
        private byte[] bytes = null;

        public BigObject(int factor) {
            bytes = new byte[(factor + 1) * 1024 * 1024];
        }

        public byte[] getBytes() {
            return bytes;
        }
    }
}
