package com.myshare.memory;

import com.bkc.util.ProcessUtil;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        System.out.println("ready to start " + ProcessUtil.getProcessID());
        String str = "qwertyuiop[]asdfghjkl;'zxcvbnm,./87y4hrjfiv8cd7seyw3gh4jrifdck"
            + "`1234567890-=   QWERTYUIOP[]Asdfghjkl;'Zxcvbnm,./098765rdfvbnjKOI*&^%$ERTYukjmnbvcde45^&*IJHGFDR"
            + "qwertyuiolkjhgfdewq21`1234567890okjnbvfdsazkiuytgfvbnhjytredsdfrt546789okjbgy789iOIUY^&*(IOKJHY&*(IOKJNBGF";

        float i = 0.002f;
        float j = 232.12334f;

        int kk = 100000;
        while (kk > 0) {
            kk--;
            j = i * j;
            str.indexOf("#");

            List<String> list = new ArrayList<>();
            for (int k = 0; k < 10000; k++) {
                list.add(str + String.valueOf(k));
            }
            list.contains("iii");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (kk % 5 == 0) {
                System.gc();
            }
        }
    }
}
