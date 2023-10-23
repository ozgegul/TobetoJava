package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // String -> camelCase description
        String text = "İlginizi çekebilir.";
        String subText = "Vade süresi.";

        System.out.println(text);

        // Integer
        int maturity = 12;

        double dollarYesterday = 18.25;
        double dollarToday = 18.20;

        // Boolean
        boolean dollarDown = false;

        String arrowDirection = "";

        // IF Blocks
        if (dollarToday < dollarYesterday){ // true
            arrowDirection = "down.svg";
            System.out.println(arrowDirection);
        } else if (dollarToday > dollarYesterday){
            arrowDirection = "up.svg";
            System.out.println(arrowDirection);
        }
        else {
            arrowDirection = "equal.svg";
            System.out.println(arrowDirection);
        }

        // Array
        String [] credits = {"Hızlı Kredi", "Mutlu Emekli"};

        // For Loop
        for (int i = 0; i < credits.length; i++){
            System.out.println(credits[i]);
        }
    }
}