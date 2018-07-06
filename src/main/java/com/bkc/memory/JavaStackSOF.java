package com.bkc.memory;

/**
 * VM Args: -Xss128k
 * @author bkc
 */
public class JavaStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaStackSOF javaStackSOF = new JavaStackSOF();
        try {

            javaStackSOF.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:" + javaStackSOF.stackLength);
            throw e;
        }
    }
}
