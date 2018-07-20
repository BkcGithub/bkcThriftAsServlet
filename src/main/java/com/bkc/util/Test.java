package com.bkc.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        InputStreamReader isr = null;
        String fileName = "/Users/bkc/Desktop/text";
        try {
            isr = new InputStreamReader(new FileInputStream(fileName), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineTxt;
            while ((lineTxt = br.readLine()) != null) {
                //userIdList.add(lineTxt);
                sb.append(lineTxt);

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] s = sb.toString().split("onebest");

        StringBuffer sb2 = new StringBuffer();
        for (int i = 1; i < s.length; i++) {
            int index = s[i].indexOf("\",\"");
            sb2.append(",  ").append(s[i].substring(0, index));
        }
        System.out.println(2);

    }
}
