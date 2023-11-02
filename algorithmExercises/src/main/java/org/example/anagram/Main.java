package org.example.anagram;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // How to check if two Strings are anagrams of each other?
        // A word or phrase made by transposing the letters of another word or phrase. (earth – heart)

        String str1 = "Heart";
        String str2 = "Earth";

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // length check
        if(str1.length() == str2.length()){
            //convert string to CharArray()
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();

            // sort the char array
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            // if arrays are the same then anagram
            boolean result = Arrays.equals(charArray1, charArray2);

            if(result){
                System.out.println(str1 + " and " + str2 + " are anagram.");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagram.");
            }
        }
        else { //if strings are not the same
            System.out.println(str1 + " and " + str2 + " are not anagram.");
        }
    }
}