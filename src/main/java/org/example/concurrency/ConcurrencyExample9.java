package org.example.concurrency;

import java.util.Arrays;

public class ConcurrencyExample9 {

    public static void main(String[] args) {
        printParallelStream();
    }

    // will not be printed in order
    private static void printParallelStream() {
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallelStream()
                .forEach(number -> System.out.print(number + " "));
    }

}
