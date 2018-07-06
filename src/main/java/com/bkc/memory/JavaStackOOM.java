package com.bkc.memory;

/**
 * VM Args: -Xss2M
 * @author bkc
 */
public class JavaStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });

            thread.start();
        }
    }

    public static void main(String[] args) {
        /*JavaStackOOM oom = new JavaStackOOM();
        oom.stackLeakByThread();*/

        String str1 = new StringBuilder("计算机").append("软件").toString();

        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();

        System.out.println(str2.intern() == str2);


    }

}
