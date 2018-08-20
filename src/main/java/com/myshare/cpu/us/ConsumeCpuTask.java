package com.myshare.cpu.us;

import java.util.ArrayList;
import java.util.List;

public class ConsumeCpuTask implements Runnable {
    @Override public void run() {
        String str = "qwertyuiop[]asdfghjkl;'zxcvbnm,./87y4hrjfiv8cd7seyw3gh4jrifdck"
            + "`1234567890-=   QWERTYUIOP[]Asdfghjkl;'Zxcvbnm,./098765rdfvbnjKOI*&^%$ERTYukjmnbvcde45^&*IJHGFDR"
            + "qwertyuiolkjhgfdewq21`1234567890okjnbvfdsazkiuytgfvbnhjytredsdfrt546789okjbgy789iOIUY^&*(IOKJHY&*(IOKJNBGF";

        float i = 0.002f;
        float j = 232.12334f;

        while (true) {
            j = i * j;
            str.indexOf("#");

            List<String> list = new ArrayList<>();
            for (int k = 0; k < 10000; k++) {
                list.add(str + String.valueOf(k));
                //us optimize
                if (k % 50 == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            list.contains("iii");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
