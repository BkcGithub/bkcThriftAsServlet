package com.myshare.us;

public class UsTestDemo {

    private void runTest() {
        int count = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < count; i++) {
            new Thread(new ConsumeCpuTask()).start();
        }

        for (int i = 0; i < 200; i++) {
            new Thread(new NotConsumeCpuTask()).start();
        }
    }

    public static void main(String[] args) {
        UsTestDemo demo = new UsTestDemo();

        demo.runTest();
    }
}
