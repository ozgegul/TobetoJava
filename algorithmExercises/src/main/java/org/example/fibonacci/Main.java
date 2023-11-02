package org.example.fibonacci;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // Write a Java function to print first 100 numbers in Fibonacci series.
        // Fibonacci sequence is a sequence in which each number is the sum of the two preceding ones.
        // 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584

        BigInteger A = BigInteger.valueOf(0);
        BigInteger B = BigInteger.valueOf(1);

        System.out.println("The first 100 Fibonacci numbers are:");
        System.out.println(A);
        System.out.println(B);

        for (int i = 2; i < 100; i++) {
            BigInteger C = A.add(B); // ==> int c = a + b;
            A = B;
            B = C;
            System.out.println(C);

        }
    }
}