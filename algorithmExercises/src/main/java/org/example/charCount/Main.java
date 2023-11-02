package org.example.charCount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write a Java program gives character counts in a string
        // E.g.Tobeto -> t:2, o:2, b:1, e:1

        String string;
        int i, length, counter[] = new int[256];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String: ");
        string = scanner.nextLine();

        length = string.length();

        for(i = 0; i < length; i++){
            counter[(int) string.charAt(i)]++;
        }
        for(i = 0; i < 256; i++){ // print the frequency of every character
            if(counter[i] != 0){
                System.out.println((char) i + " " + counter[i]);
            }
        }
    }

}
