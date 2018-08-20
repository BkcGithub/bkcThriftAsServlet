package com.myshare.cpu.sy;

public class SyTestDemo {


    public static void main(String[] args) {
        SyHighDemo syHighDemo = new SyHighDemo();

        try {
            syHighDemo.runTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
