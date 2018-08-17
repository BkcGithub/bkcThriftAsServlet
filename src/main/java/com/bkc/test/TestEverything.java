package com.bkc.test;

import org.apache.commons.collections.map.HashedMap;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class TestEverything {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    private static final Exchanger<String> exchenger = new Exchanger<>();

    private static final ExecutorService service = Executors.newFixedThreadPool(2);



    public static void main(String[] args) {
        /*int initialCapacity = 20;
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;

        System.out.println(capacity);

        Map<String, Object> map = new HashedMap();
        String key1 = "key1";
        System.out.println(map.put(null, "12"));
        System.out.println(map.put(key1,"key1"));

        System.out.println(map.put(key1,"key2"));


        Hashtable hashtable = new Hashtable();

        hashtable.put("1", "1");

        ConcurrentHashMap map1 = new ConcurrentHashMap();

        map1.put("1", "1");

        String a = "a";
        String b = "a";

        System.out.println(a == b);*/

        /*new Thread(new Runnable() {
            @Override public void run() {

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);*/

        /*Thread thread = new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        //thread.interrupt();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(cyclicBarrier.isBroken());*/

        /*Semaphore semaphore = new Semaphore(10);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 30; i++) {
            int finalI = i;
            fixedThreadPool.execute(new Runnable() {
                @Override public void run() {
                    try {

                        semaphore.acquire();
                        System.out.println("save Date " + semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    semaphore.release();
                }
            });

        }*/
        service.execute(new Runnable() {
            @Override public void run() {
                String str1 = "str1";
                try {
                    exchenger.exchange(str1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        service.execute(new Runnable() {
            @Override public void run() {
                String str2 = "str2";
                try {
                    String str1 = exchenger.exchange(str2);
                    System.out.println(str1 + "-" + str2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Executors.newFixedThreadPool(10);
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Object> future = (Future<Object>) service.submit(new Runnable() {
            @Override public void run() {

                System.out.println(1);
            }
        });
        try {
            Object o = future.get();
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Executors.defaultThreadFactory();


    }

}
