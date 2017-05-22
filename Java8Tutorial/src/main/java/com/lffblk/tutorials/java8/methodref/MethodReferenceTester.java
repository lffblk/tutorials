package com.lffblk.tutorials.java8.methodref;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lffblk on 15.05.2017.
 */
public class MethodReferenceTester {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mahesh", "Suresh", "Ramesh", "Naresh", "Kalpesh");
        names.forEach(System.out::println);
    }
}
