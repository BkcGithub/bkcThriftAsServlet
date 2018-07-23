package com.bkc.thread.waitnotify;

public class Test1 {
    public static void main(String[] args) {
        String newString = new String("");

        try {
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
