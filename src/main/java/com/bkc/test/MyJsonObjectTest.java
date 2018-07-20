package com.bkc.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class MyJsonObjectTest {


    public static void main(String[] args) {
        MyJsonObjcet myJsonObjcet = new MyJsonObjcet("bkc");


        System.out.println(JSON.toJSONString(new MyJsonObjcet("bkc")));

        String str = "123";

        String str2 = new String("123");

        System.out.println(str.equals(str2));
    }
}
