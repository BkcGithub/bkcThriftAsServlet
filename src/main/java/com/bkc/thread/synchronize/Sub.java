package com.bkc.thread.synchronize;

import redis.clients.jedis.Jedis;

public class Sub extends Main {

    synchronized public void operateSub() {
        while (i > 0) {
            i--;
            System.out.println("sub print i =" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.operateMain();

        }
    }
}
