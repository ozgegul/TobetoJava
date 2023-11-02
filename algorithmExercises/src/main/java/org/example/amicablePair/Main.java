package org.example.amicablePair;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
   // Write a Java program finds first two amicable pairs. (Output: 1-> 220-284 2: 1184-1210)
   // Amicable numbers are two different natural numbers related in such a way that
   // the sum of the proper divisors of each is equal to the other number.

      int pairCount = 0;
      int number1 = 1;

      while (pairCount < 2) {
         int number2 = getSumOfDivisors(number1);
         if (number2 > number1 && number1 == getSumOfDivisors(number2)) {
            System.out.println("Amicable Pair " + (pairCount + 1) + ": " + number1 + " - " + number2);
            pairCount++;
         }
         number1++;
      }
   }

   public static int getSumOfDivisors(int n) {
      int sum = 0;
      for (int i = 1; i <= n / 2; i++) {
         if (n % i == 0) {
            sum += i;
         }
      }
      return sum;
   }
}

