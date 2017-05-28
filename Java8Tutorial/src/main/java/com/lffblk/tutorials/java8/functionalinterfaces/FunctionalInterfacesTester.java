package com.lffblk.tutorials.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lffblk on 28.05.2017.
 */
public class FunctionalInterfacesTester {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("Print all numbers:");
        eval(list, n -> true);

        System.out.println("\nPrint even numbers:");
        eval(list, n -> n % 2 == 0);

        System.out.println("\nPrint numbers greater than 3:");
        eval(list, n -> n > 3);
    }

    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) System.out.print(n + " ");
        }
    }
}
