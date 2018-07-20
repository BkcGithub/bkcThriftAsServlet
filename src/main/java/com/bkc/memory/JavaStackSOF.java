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
        System.out.println(Long.parseLong("-100"));
        String str= "100";
        char c1 = str.charAt(0);
        System.out.println(c1 - 48);

        /*JavaStackSOF javaStackSOF = new JavaStackSOF();
        try {

            javaStackSOF.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:" + javaStackSOF.stackLength);
            throw e;
        }*/
    }
}
