package com.bkc.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Tester2 {
    public static void main(String[] args) {
        //thread
        new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("1212121");
            }
        }).start();


        new Thread(() -> System.out.println("1212121")).start();

        //sort
        String[] datas = new String[] {"you", "peng", "bkc"};
        Arrays.sort(datas);
        Stream.of(datas).forEach(new Consumer<String>() {
            @Override public void accept(String s) {
                System.out.println(s);
            }
        });
        Stream.of(datas).forEach(param -> System.out.println(param));


        Arrays.sort(datas, (v1, v2) -> Integer.compare(v1.length(), v2.length()));
        //Arrays.sort(datas, Comparator.comparingInt(String::length));

        Stream.of(datas).forEach(param -> System.out.println(param));
        Arrays.sort(datas, new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                return 0;
            }
        });

        System.out.println("\r\n");
        Arrays.sort(datas, (v1, v2)->v1.length() - v2.length());



        Arrays.sort(datas,String::compareToIgnoreCase);
        Stream.of(datas).forEach(num -> System.out.println(num));
        Stream.of(datas).forEach(System.out::println);
    }
}
