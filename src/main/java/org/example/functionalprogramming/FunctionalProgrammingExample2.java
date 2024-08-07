package org.example.functionalprogramming;

import java.util.Arrays;

public class FunctionalProgrammingExample2 {

    public static void main(String[] args) {
        useReduceChar();
        useReduceString();
    }

    /* .reduce(identity, accumulator, combiner)
        Identity
            – an element that is the initial value of the reduction operation and the default result if the stream
            is empty
        itemAccumulator
            – a function that takes two parameters: a partial result of the reduction operation and the next element
            of the stream
        Combiner
            - a function used to combine the partial result of the reduction operation when the reduction is
            parallelized, or when there’s a mismatch between the types of the accumulator arguments and the types
            of the accumulator implementation
            Note: When a stream executes in parallel, the Java runtime splits the stream into multiple substreams.
            In such cases, we need to use a function to combine the results of the substreams into a single one.
            This is the role of the combiner
    */

    private static void useReduceChar() {
        String string = Arrays.asList('w', 'o', 'l', 'f')
                .stream()
                .reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3);
        System.out.println(string);
    }

    private static void useReduceString() {
        String string = Arrays.asList("w", "o", "l", "f")
                .stream()
                .reduce("", (c, s1) -> c + s1);
        System.out.println(string);
    }

}
