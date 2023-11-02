package org.example.armstrongNumber;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Write a Java program to check if the entered number is Armstrong number?
        // Armstrong number is a number that is equal to the sum of cubes of its digits.
        // (1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371)

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int number = input.nextInt();
        int originalNumber = number;
        int changeNumber;
        int counter = 0;
        int numberMod;
        double numberPow = 0;

        while (number > 0) {
            number /= 10;
            counter++;
        }

        changeNumber = originalNumber;

        while (changeNumber != 0) {
            numberMod = changeNumber % 10;
            numberPow += Math.pow(numberMod, counter);
            changeNumber /= 10;
        }

        if (numberPow == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number. ");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number. ");
        }
    }
}