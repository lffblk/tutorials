package com.lffblk.tutorials.java8.lambda;

/**
 * Created by lffblk on 15.05.2017.
 */
public class LambdaTester {
    public static void main(String[] args) {
        // with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        // without type declaration
        MathOperation subtraction = (a, b) -> a - b;

        // with return statement
        MathOperation multiplication = (a, b) -> {return a * b;};

        // without return statement
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 5 = " + addition.operation(10, 5));
        System.out.println("10 - 5 = " + subtraction.operation(10, 5));
        System.out.println("10 * 5 = " + multiplication.operation(10, 5));
        System.out.println("10 / 5 = " + division.operation(10, 5));

        GreetingService greetingService = name -> System.out.println("\nHello " + name);
        greetingService.sayMessage("World");

        // final variable in lambdas
        final String message = "Goodbye ";
        GreetingService greetingServiceUsingFinalVariable = name -> System.out.println(message + name);
        greetingServiceUsingFinalVariable.sayMessage("World");
    }
}
