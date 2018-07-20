package com.bkc.test;

import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestEverything {
    public static void main(String[] args) {
        int initialCapacity = 20;
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;

        System.out.println(capacity);

        Map<String, Object> map = new HashedMap();
        String key1 = "key1";
        System.out.println(map.put(null, "12"));
        System.out.println(map.put(key1,"key1"));

        System.out.println(map.put(key1,"key2"));


        Hashtable hashtable = new Hashtable();

        hashtable.put("1", "1");

        ConcurrentHashMap map1 = new ConcurrentHashMap();

        map1.put("1", "1");

        List<String> strList = new ArrayList<>();
    }

}
