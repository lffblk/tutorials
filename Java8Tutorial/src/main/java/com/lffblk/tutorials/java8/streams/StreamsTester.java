package com.lffblk.tutorials.java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by lffblk on 28.05.2017.
 */
public class StreamsTester {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("Strings: " + strings);

        // Count empty strings
        long emptyStringsCount = strings.stream().filter(String::isEmpty).count();
        System.out.println("Empty strings count = " + emptyStringsCount);

        // Count strings of length 3
        long stringsOfLength3Count = strings.stream().filter(str -> str.length() == 3).count();
        System.out.println("Strings of length 3 = " + stringsOfLength3Count);

        //Eliminate empty strings
        List<String> notEmptyStrings = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println("Not empty strings: " + notEmptyStrings);

        //Eliminate empty strings and join using comma
        String mergedString = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged string: " + mergedString);

        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("\nIntegers: " + integers);

        //get list of square of distinct numbers
        List<Integer> squareList = integers.stream().map(element -> element * element).collect(Collectors.toList());
        System.out.println("Square list : " + squareList);

        integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("\nIntegers: " + integers);

        IntSummaryStatistics statistics = integers.stream().mapToInt(n -> n).summaryStatistics();
        System.out.println("Highest number in List : " + statistics.getMax());
        System.out.println("Lowest number in List : " + statistics.getMin());
        System.out.println("Sum of all numbers : " + statistics.getSum());
        System.out.println("Average of all numbers : " + statistics.getAverage());

        Random random = new Random();
        System.out.println("\nRandom Numbers: ");
        random.ints().limit(10).forEach(System.out::println);

        //parallel processing
        System.out.println("\nParallel processing");
        emptyStringsCount = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("Empty strings count = " + emptyStringsCount);
    }
}
