package com.bkc.test;

import com.bkc.service.GreetingService;
import com.bkc.service.MathOperation;

public class Java8Tester {
    final static  String salution = "BKC";
    public static void main(String[] args) {
        Java8Tester tester = new Java8Tester();
        MathOperation addition = (int a, int b) -> a + b;

        MathOperation substration = (a, b) -> a - b;

        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));

        GreetingService service = message -> System.out.println(salution + message);

        service.sayMessage("Runoob");
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
