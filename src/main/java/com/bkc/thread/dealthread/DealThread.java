package com.bkc.thread.dealthread;

public class DealThread implements Runnable {
    public String userName;
    public Object object1 = new Object();
    public Object object2 = new Object();

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override public void run() {

        if (userName.equals("a")) {
            synchronized (object1) {
                try {
                    System.out.println("userName = " + userName);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println("按object1 -> object2的代码执行了");
                }
            }
        }
        if (userName.equals("b")) {
            synchronized (object2) {
                try {
                    System.out.println("userName = " + userName);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("按object2 -> object1的代码执行了");
                }
            }
        }
    }
}
