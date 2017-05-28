package com.lffblk.tutorials.java8.optional;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by lffblk on 28.05.2017.
 */
public class OptionalTester {
    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = 10;

        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.ofNullable(value2);

        System.out.println("Sum = " + sum(a, b));
    }

    private static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        Integer value1 = a.orElse(0);
        Integer value2 = b.orElse(0);

        return value1 + value2;
    }
}
