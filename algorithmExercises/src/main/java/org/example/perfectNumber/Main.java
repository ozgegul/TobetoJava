package org.example.perfectNumber;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // Write a Java program finds first 10 perfect numbers.
        // Perfect Number: A positive integer that is equal to the sum of its proper divisors.
        // 6, 28, 496, 8128, 33550336

        int count = 0;
        int n = 2;
        BigInteger[] perfectNumbers = new BigInteger[10];

        while (count < 10) {
            BigInteger number = BigInteger.valueOf(2).pow(n - 1);
            BigInteger isPrime = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);

            if (isPrime.isProbablePrime(10)) { // Prime number check
                BigInteger perfectNumber = number.multiply(isPrime);// number*isPrime
                perfectNumbers[count] = perfectNumber;
                count++;
            }
            n++;
        }

        for (BigInteger number : perfectNumbers) {
            System.out.println(number);
        }
    }
}