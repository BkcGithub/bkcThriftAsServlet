package com.bkc.test;

import org.apache.commons.collections.map.HashedMap;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
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
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestEverything {

    private static final List<String> names = new ArrayList<String>(){{add("1111");
        System.out.println(names);}};

    static Lock lock = new ReentrantLock(true);

    static ThreadLocal threadLocal = new ThreadLocal();

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    private static final Exchanger<String> exchenger = new Exchanger<>();

    private static final ExecutorService service = Executors.newFixedThreadPool(2);


    public synchronized void method1() {
        for (int i = 0; i < 100; i++) {
            System.out.println("method1 " + i);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static synchronized void method2() {
        for (int i = 0; i < 100; i++) {
            System.out.println("method2 " + i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

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
        /*service.execute(new Runnable() {
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
        Executors.defaultThreadFactory();*/


        /*long value = ThreadLocalRandom.current().nextLong(2L << 32);
        System.out.println(value);
        System.out.println(2L << 32);
        System.out.println("1000000000000000000000000000000000".length());
        System.out.println(value >> 2 << 2);

        List<String> list = new ArrayList<>();
        list.add("111");
        list.remove(1);

        list.iterator();
        int oldCapacity = 10;
        System.out.println(oldCapacity >> 1);*/

        /*TestEverything testEverything = new TestEverything();
        TestEverything testEverything1 = new TestEverything();
            new Thread(new Runnable() {
                @Override public void run() {
                    testEverything.method1();

                }
            }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                TestEverything.method2();

            }
        }).start();*/

        System.out.println(threadLocal.get());
        String str = "1234521";
        Integer integer = Integer.parseInt(str);

        char c = '1';
        int digit = Character.digit(c, 10);
        System.out.println(digit);

        lock.lock();

        Integer[] ints = {1, 2, 3, 4, 5, 1, 2,4 ,9};
        Integer[] intsNew = Arrays.copyOf(ints, 10);

        System.out.println(ints == intsNew);
        System.out.println(intsNew.length);

        List<Integer> list = new LinkedList<>();
        list.add(0, 1);
        list.set(0, 10);

        List<Integer> list1 = Arrays.asList(ints);
        Integer i = 1;
        list1.remove(null);

        System.out.println(list1);

        System.out.println(names);


    }

}
