package com.bkc.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Stream {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, null, 3, 4, null, 6, 4, 6, 8, 3);

        System.out.println(nums.stream().filter(num -> num != null).count());

        nums.stream().filter(num -> num != null).filter(num -> num.compareTo(3) > 0)
            .forEach(num -> System.out.println(num));

        // Stream.generate(() -> new Integer[] {1, 2, 3, 4, 5}).forEach(num -> System.out.println(num));
        // Stream.iterate(1, item -> item + 3).limit(100).forEach(num -> System.out.println(num));

        System.out.println("\r\n");
        nums.stream().distinct().forEach(num -> System.out.println(num));
        nums.stream().filter(num -> num != null).mapToDouble(num -> Double.valueOf(num))
            .forEach(num -> System.out.println(num));


        List<Integer> numsWithoutNull = nums.stream().filter(num -> null != num).distinct().collect(Collectors.toList());

        System.out.println(numsWithoutNull);
    }
}
